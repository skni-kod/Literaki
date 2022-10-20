package SKNI.KOD.Literaki.DTO.response;

import SKNI.KOD.Literaki.entity.logs.MailAttempt;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
public class MailAttemptResponse {
    private ZonedDateTime attemptDate;
    private String sentTo;
    private String body;
    private Boolean isSuccessful;

    public MailAttemptResponse(MailAttempt mailAttempt) {
        attemptDate = mailAttempt.getAttemptDate();
        sentTo = mailAttempt.getSentTo();
        body = mailAttempt.getBody();
        isSuccessful = mailAttempt.getIsSuccessful();
    }
}
