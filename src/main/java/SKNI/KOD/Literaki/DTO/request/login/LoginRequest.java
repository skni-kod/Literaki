package SKNI.KOD.Literaki.DTO.request.login;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

}
