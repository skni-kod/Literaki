package SKNI.KOD.Literaki.DTO.response.auth;

import SKNI.KOD.Literaki.entity.logs.MailAttempt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MailAttemptResponse {
    private ZonedDateTime attemptDate;
    private String sentTo;
    private String body;
    private Boolean isSuccessful;

    public MailAttemptResponse(MailAttempt mailAttempt) {
        attemptDate = mailAttempt.getAttemptDate();
        sentTo = mailAttempt.getSentTo();
        body = mailAttempt.getTitle();
        isSuccessful = mailAttempt.getIsSuccessful();
    }
}
