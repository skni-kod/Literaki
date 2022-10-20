package SKNI.KOD.Literaki.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MailAttemptRequest {
    @NotNull
    private String mailTitle;
    @NotNull
    private Boolean successful;

    @NotNull
    private String sentTo;

    @Nullable
    private String requestingUser;

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public MailAttemptRequest(MailRequest mailRequest,Boolean successful, String username){
        mailTitle =mailRequest.getTitle();
        this.successful=successful;
        sentTo=mailRequest.getSendTo();
        requestingUser=username;
    }
}
