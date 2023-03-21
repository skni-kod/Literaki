package SKNI.KOD.Literaki.service.security;

import SKNI.KOD.Literaki.DTO.request.login.ChangePasswordRequest;
import SKNI.KOD.Literaki.DTO.request.login.LogRequest;
import SKNI.KOD.Literaki.DTO.request.login.LoginRequest;
import SKNI.KOD.Literaki.DTO.request.login.MailRequest;
import SKNI.KOD.Literaki.DTO.response.auth.LoginResponse;
import SKNI.KOD.Literaki.DTO.response.auth.MailAttemptResponse;
import SKNI.KOD.Literaki.entity.login.Login;
import SKNI.KOD.Literaki.entity.login.LoginRole;
import SKNI.KOD.Literaki.entity.login.VerificationToken;
import SKNI.KOD.Literaki.repository.login.Login2RoleRepository;
import SKNI.KOD.Literaki.repository.login.LoginRepository;
import SKNI.KOD.Literaki.repository.login.RoleRepository;
import SKNI.KOD.Literaki.service.logs.LogService;
import SKNI.KOD.Literaki.service.message.MailService;
import SKNI.KOD.Literaki.service.user.ProfileService;
import SKNI.KOD.Literaki.util.ERole;
import SKNI.KOD.Literaki.util.HttpServletRequestResolver;
import SKNI.KOD.Literaki.util.Regexes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LoginService {
    private static final String VERIFY_PATH = "/login/verify/";
    private static final String VERIFY_MAIL_TITLE = "Potwierdzenie rejestracji - Projekt Literaki";
    private static final String VERIFY_HEADER = "Potwierdzenie Rejestracji";
    private static final String VERIFY_TITLE = "Dziękujemy za utworzenie konta w Projekcie Literaki\n" +
            "Aby aktywować konto, kliknij poniższy przycisk.";
    private static final String VERIFY_BUTTON = "Aktywacja Konta";
    private static final String PASS_RESET_PATH = "/login/resetPassword/";
    private static final String PASS_RESET_MAIL_TITLE = "Odzyskiwanie hasła - Projekt Literaki";
    private static final String PASS_RESET_HEADER = "Odzyskiwanie hasła";
    private static final String PASS_RESET_TITLE = "Poniżej znajdziesz link, pozwalający na ustawienie nowego hasła.";
    private static final String PASS_RESET_BUTTON = "Resetuj hasło";

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private VerificationTokenService verificationTokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private Login2RoleRepository login2RoleRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private MailService mailService;
    @Autowired
    private LogService logService;

    private boolean loginAndEmailAvailable(HttpServletRequest httpServletRequest, LoginRequest loginRequest) {
        try {
            return loginRepository.findByUsernameOrEmail(loginRequest.getUsername(), loginRequest.getEmail()).isEmpty();
        } catch (Exception e) {
            logService.createErrorLog(new LogRequest(httpServletRequest.getRemoteAddr(), "User already registered"));
            return false;
        }
    }

    private boolean passwordMatchesRequirements(HttpServletRequest httpServletRequest, String password) {
        Pattern pattern = Pattern.compile(Regexes.EIGHT_LETTER_NUMBER);
        Matcher matcher = pattern.matcher(password);
        if(!matcher.matches())
            logService.createErrorLog(new LogRequest(httpServletRequest.getRemoteAddr(), "Password doesn't match requirements"));
        return matcher.matches();
    }

    private boolean emailMeetsRequirements(HttpServletRequest httpServletRequest, String email) {
        Pattern pattern = Pattern.compile(Regexes.EMAIL);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches())
            logService.createErrorLog(new LogRequest(httpServletRequest.getRemoteAddr(), "Email doesn't meet requirements"));
        return matcher.matches();
    }

    public LoginResponse createLogin(LoginRequest loginRequest, HttpServletRequest httpServletRequest) {
        logService.createInfoLog(new LogRequest(httpServletRequest.getRemoteAddr(), "Attempting to register a new user"));
        if (loginAndEmailAvailable(httpServletRequest, loginRequest) && passwordMatchesRequirements(httpServletRequest, loginRequest.getPassword()) && emailMeetsRequirements(httpServletRequest, loginRequest.getEmail())) {
            Login newLogin = Login.builder()
                    .username(loginRequest.getUsername())
                    .email(loginRequest.getEmail())
                    .password(passwordEncoder.encode(loginRequest.getPassword()))
                    .verificationToken(verificationTokenService.createVerificationToken())
                    .build();
            Login savedLogin = loginRepository.save(newLogin);
            MailAttemptResponse mailAttemptResponse = sendVerificationEmail(savedLogin.getEmail(), savedLogin.getVerificationToken().getToken(), httpServletRequest);
            return new LoginResponse(savedLogin);
        }
        return null;
    }

    private MailAttemptResponse sendVerificationEmail(String sendTo, String verificationToken, HttpServletRequest httpServletRequest) {
        Context context = new Context();
        context.setVariable("header", VERIFY_HEADER);
        context.setVariable("title", VERIFY_TITLE);
        context.setVariable("button", VERIFY_BUTTON);
        context.setVariable("link", HttpServletRequestResolver.getServerPathFromRequest(httpServletRequest) + VERIFY_PATH + verificationToken);
        String body = templateEngine.process("mailTemplate", context);
        return mailService.sendEmail(new MailRequest(sendTo, VERIFY_MAIL_TITLE, body));
    }

    private MailAttemptResponse sendPasswordResetEmail(String sendTo, String verificationToken, HttpServletRequest httpServletRequest) {
        Context context = new Context();
        context.setVariable("header", PASS_RESET_HEADER);
        context.setVariable("title", PASS_RESET_TITLE);
        context.setVariable("button", PASS_RESET_BUTTON);
        context.setVariable("link", HttpServletRequestResolver.getServerPathFromRequest(httpServletRequest) + PASS_RESET_PATH + verificationToken);
        String body = templateEngine.process("mailTemplate", context);
        return mailService.sendEmail(new MailRequest(sendTo, PASS_RESET_MAIL_TITLE, body));
    }

    public LoginResponse verifyLogin(String token) {
        try {
            VerificationToken foundToken = verificationTokenService.findToken(token);
            if (foundToken == null)
                return null;
            Login login = loginRepository.findByVerificationToken(foundToken).get();
            if (!login.getVerified() && login.getVerificationToken() != null && login.getVerificationToken().getToken().equals(token) && login.getVerificationToken().getExpiryDate().isAfter(ZonedDateTime.now())) {
                login.setVerified(true);
                login.setVerificationToken(null);
                verificationTokenService.removeVerificationToken(foundToken);
                Login savedLogin = loginRepository.save(login);
                LoginRole loginRole = LoginRole.builder()
                        .login(login)
                        .role(roleRepository.findByName(ERole.ROLE_USER).get()).build();
                login2RoleRepository.save(loginRole);
                profileService.createProfile(savedLogin);
                return new LoginResponse(savedLogin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public LoginResponse changePassword(ChangePasswordRequest changePasswordRequest, HttpServletRequest httpServletRequest) {
        Login savedLogin = null;
        logService.createInfoLog(new LogRequest(httpServletRequest.getRemoteAddr(), "Attempting to change password"));
        if (loginRepository.existsByUsername(changePasswordRequest.getUsername())) {
            Login login = loginRepository.findByUsernameIgnoreCase(changePasswordRequest.getUsername()).get();
            if (passwordMatchesRequirements(httpServletRequest,changePasswordRequest.getNewPassword())) {
                if (passwordEncoder.matches(changePasswordRequest.getOldPassword(), login.getPassword())) {
                    login.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
                    savedLogin = loginRepository.save(login);
                    logService.createTraceLog(new LogRequest(httpServletRequest.getRemoteAddr(), "successfully changed password"));
                } else {
                    logService.createErrorLog(new LogRequest(httpServletRequest.getRemoteAddr(), "change password: Old password does not match"));
                }
            } else {
                logService.createErrorLog(new LogRequest(httpServletRequest.getRemoteAddr(), "change password: New password does not meet requirements"));
            }
        } else {
            logService.createErrorLog(new LogRequest(httpServletRequest.getRemoteAddr(), "change password: User not found"));
        }
        return new LoginResponse(savedLogin);
    }

    public LoginResponse forgotPassword(String email, HttpServletRequest httpServletRequest) {
        logService.createInfoLog(new LogRequest(httpServletRequest.getRemoteAddr(), "Attempt to reset password of: " + email));
        Login login = null;
        if (loginRepository.existsByEmail(email)) {
            login = loginRepository.findByEmail(email).get();
            login.setVerificationToken(verificationTokenService.createVerificationToken());
            MailAttemptResponse mailAttemptResponse = sendPasswordResetEmail(login.getEmail(), login.getVerificationToken().getToken(), httpServletRequest);
        } else {
            logService.createErrorLog(new LogRequest(httpServletRequest.getRemoteAddr(), "change password: User not found"));
        }
        return new LoginResponse(login);
    }

    public LoginResponse resetPassword(String token, String password, HttpServletRequest httpServletRequest) {
        try {
            VerificationToken foundToken = verificationTokenService.findToken(token);
            if (foundToken == null)
                return null;
            Login login = loginRepository.findByVerificationToken(foundToken).get();
            if (passwordMatchesRequirements(httpServletRequest,password) && login.getVerified() && login.getVerificationToken() != null && login.getVerificationToken().getToken().equals(token) && login.getVerificationToken().getExpiryDate().isAfter(ZonedDateTime.now())) {
                login.setPassword(passwordEncoder.encode(password));
                Login savedLogin = loginRepository.save(login);
                logService.createTraceLog(new LogRequest(httpServletRequest.getRemoteAddr(), "Successfully reseted password"));
                return new LoginResponse(savedLogin);
            } else {
                logService.createErrorLog(new LogRequest(httpServletRequest.getRemoteAddr(), "Failed during password reset"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
