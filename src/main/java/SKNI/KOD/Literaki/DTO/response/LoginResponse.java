package SKNI.KOD.Literaki.DTO.response;

import SKNI.KOD.Literaki.entity.login.Login;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private Long id;
    private String username;
    private String email;
    private Boolean verified;
    private String verificationToken;

    public LoginResponse(Login login) {
        id = login.getId();
        username = login.getUsername();
        email = login.getEmail();
        verified = login.getVerified();
        try {
            verificationToken = login.getVerificationToken().getToken();
        }catch (NullPointerException e){
            verificationToken = null;
        }
    }
}
