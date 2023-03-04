package SKNI.KOD.Literaki.DTO.request.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class MailRequest {
    @NotNull
    private String sendTo;
    private String title;
    private String contentString;
}
