package SKNI.KOD.Literaki.service.security;

import SKNI.KOD.Literaki.DTO.request.LoginRequest;
import SKNI.KOD.Literaki.DTO.request.MailRequest;
import SKNI.KOD.Literaki.DTO.response.LoginResponse;
import SKNI.KOD.Literaki.DTO.response.MailAttemptResponse;
import SKNI.KOD.Literaki.entity.login.Login;
import SKNI.KOD.Literaki.entity.login.LoginRole;
import SKNI.KOD.Literaki.entity.login.VerificationToken;
import SKNI.KOD.Literaki.repository.Login2RoleRepository;
import SKNI.KOD.Literaki.repository.LoginRepository;
import SKNI.KOD.Literaki.repository.RoleRepository;
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

import javax.servlet.http.HttpServletRequest;
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

    private boolean loginAndEmailAvailable(LoginRequest loginRequest){
        try{
            return loginRepository.findByUsernameOrEmail(loginRequest.getUsername(), loginRequest.getEmail()).isEmpty();
        }catch(Exception e){
            return false;
        }
    }
    private boolean passwordMatchesRequirements(String password){
        Pattern pattern = Pattern.compile(Regexes.EIGHT_LETTER_NUMBER);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private boolean emailMeetsRequirements(String email){
        Pattern pattern = Pattern.compile(Regexes.EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public LoginResponse createLogin(LoginRequest loginRequest,HttpServletRequest httpServletRequest){
        if(loginAndEmailAvailable(loginRequest) && passwordMatchesRequirements(loginRequest.getPassword()) && emailMeetsRequirements(loginRequest.getEmail())) {
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
    private MailAttemptResponse sendVerificationEmail(String sendTo, String verificationToken, HttpServletRequest httpServletRequest){
        Context context = new Context();
        context.setVariable("header",VERIFY_HEADER);
        context.setVariable("title", VERIFY_TITLE);
        context.setVariable("button",VERIFY_BUTTON );
        context.setVariable("link", HttpServletRequestResolver.getServerPathFromRequest(httpServletRequest)+VERIFY_PATH+verificationToken);
        String body = templateEngine.process("mailTemplate",context);
        return mailService.sendEmail(new MailRequest(sendTo,VERIFY_MAIL_TITLE,body));
    }

    public LoginResponse verifyLogin(String token){
        try {
            VerificationToken foundToken = verificationTokenService.findToken(token);
            if(foundToken == null)
                return null;
            Login login = loginRepository.findByVerificationToken(foundToken).get();
            if(login.getVerificationToken()!=null && login.getVerificationToken().getToken().equals(token) && login.getVerificationToken().getExpiryDate().isAfter(ZonedDateTime.now())) {
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
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
