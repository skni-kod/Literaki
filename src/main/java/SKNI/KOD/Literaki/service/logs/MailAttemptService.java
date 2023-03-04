package SKNI.KOD.Literaki.service.logs;

import SKNI.KOD.Literaki.DTO.request.login.MailAttemptRequest;
import SKNI.KOD.Literaki.DTO.response.auth.MailAttemptResponse;
import SKNI.KOD.Literaki.entity.logs.MailAttempt;
import SKNI.KOD.Literaki.repository.login.MailAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class MailAttemptService {

    @Autowired
    private MailAttemptRepository mailAttemptRepository;

    public MailAttemptResponse createMailAttempt(MailAttemptRequest mailAttemptRequest){
        MailAttempt mailAttempt = MailAttempt.builder()
                .title(mailAttemptRequest.getMailTitle())
                .requestingUser(mailAttemptRequest.getRequestingUser())
                .sentTo(mailAttemptRequest.getSentTo())
                .attemptDate(ZonedDateTime.now())
                .isSuccessful(mailAttemptRequest.getSuccessful())
                .build();
        MailAttempt savedMailAttempt = mailAttemptRepository.save(mailAttempt);
        return new MailAttemptResponse(savedMailAttempt);
    }
}
