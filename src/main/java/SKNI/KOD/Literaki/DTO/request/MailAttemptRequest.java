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
    private String body;
    @NotNull
    private Boolean successful;

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    @Nullable
    private String requestingUser;
}
