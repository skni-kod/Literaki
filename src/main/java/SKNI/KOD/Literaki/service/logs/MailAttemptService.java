package SKNI.KOD.Literaki.service.logs;

import SKNI.KOD.Literaki.DTO.request.MailAttemptRequest;
import SKNI.KOD.Literaki.DTO.response.MailAttemptResponse;
import SKNI.KOD.Literaki.entity.logs.MailAttempt;
import SKNI.KOD.Literaki.repository.MailAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class MailAttemptService {
    private static final ZoneId poland = ZoneId.of("Poland");

    @Autowired
    private MailAttemptRepository mailAttemptRepository;

    public MailAttemptResponse createMailAttempt(MailAttemptRequest mailAttemptRequest){
        MailAttempt mailAttempt = MailAttempt.builder()
                .body(mailAttemptRequest.getBody())
                .requestingUser(mailAttemptRequest.getRequestingUser())
                .sentTo(mailAttemptRequest.getSentTo())
                .attemptDate(ZonedDateTime.now())
                .isSuccessful(mailAttemptRequest.getSuccessful())
                .build();
        MailAttempt savedMailAttempt = mailAttemptRepository.save(mailAttempt);
        return new MailAttemptResponse(savedMailAttempt);
    }
}
