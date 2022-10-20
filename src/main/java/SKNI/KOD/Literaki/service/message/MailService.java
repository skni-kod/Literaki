package SKNI.KOD.Literaki.service.message;

import SKNI.KOD.Literaki.DTO.request.MailAttemptRequest;
import SKNI.KOD.Literaki.entity.logs.MailAttempt;
import SKNI.KOD.Literaki.service.logs.MailAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    //don't trust IDE, this works lol
    private JavaMailSender javaMailSender;

    @Autowired
    private MailAttemptService mailAttemptService;


    public void sendTestMail(){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("Literaki.SKNI@gmail.com");
        mail.setSubject("Test message");
        mail.setText("Test");
        mail.setTo("Literaki.SKNI@gmail.com");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        MailAttemptRequest mailAttemptRequest = new MailAttemptRequest("Test",true,currentPrincipalName);
        try {
            javaMailSender.send(mail);
        }catch (Exception e){
            mailAttemptRequest.setSuccessful(false);
            e.printStackTrace();
        }
        mailAttemptService.createMailAttempt(mailAttemptRequest);
    }
}
