package SKNI.KOD.Literaki.service.logs;

import SKNI.KOD.Literaki.DTO.request.MailAttemptRequest;
import SKNI.KOD.Literaki.entity.logs.MailAttempt;
import SKNI.KOD.Literaki.repository.MailAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class MailAttemptService {

    @Autowired
    private MailAttemptRepository mailAttemptRepository;

    public MailAttempt createMailAttempt(MailAttemptRequest mailAttemptRequest){
        MailAttempt mailAttempt = MailAttempt.builder()
                .body(mailAttemptRequest.getBody())
                .requestingUser(mailAttemptRequest.getRequestingUser())
                .attemptDate(Timestamp.from(Instant.now()))
                .isSuccessful(mailAttemptRequest.getSuccessful())
                .build();
        MailAttempt savedMailAttempt = mailAttemptRepository.save(mailAttempt);
        return savedMailAttempt;
    }
}
