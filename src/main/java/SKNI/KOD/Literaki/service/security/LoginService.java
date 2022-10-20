package SKNI.KOD.Literaki.service.security;

import SKNI.KOD.Literaki.DTO.request.LoginRequest;
import SKNI.KOD.Literaki.DTO.response.LoginResponse;
import SKNI.KOD.Literaki.entity.login.Login;
import SKNI.KOD.Literaki.entity.login.LoginRole;
import SKNI.KOD.Literaki.repository.Login2RoleRepository;
import SKNI.KOD.Literaki.repository.LoginRepository;
import SKNI.KOD.Literaki.repository.RoleRepository;
import SKNI.KOD.Literaki.service.user.ProfileService;
import SKNI.KOD.Literaki.util.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class LoginService {
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

    public LoginResponse createLogin(LoginRequest loginRequest){
        Login newLogin = Login.builder()
                .username(loginRequest.getUsername())
                .email(loginRequest.getEmail())
                .password(passwordEncoder.encode(loginRequest.getPassword()))
                .verificationToken(verificationTokenService.createVerificationToken())
                .build();
        Login savedLogin = loginRepository.save(newLogin);
        //TODO:send email with verification token
        return new LoginResponse(savedLogin);
    }

    public LoginResponse verifyLogin(LoginRequest loginRequest, String token){
        try {
            Login login = loginRepository.findByUsernameOrEmail(loginRequest.getUsername(), loginRequest.getEmail()).get();
            if(login.getVerificationToken().getToken().equals(token) && login.getVerificationToken().getExpiryDate().isAfter(ZonedDateTime.now())) {
                //TODO:maybe delete token here
                login.setVerified(true);
                login.setVerificationToken(null);
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
