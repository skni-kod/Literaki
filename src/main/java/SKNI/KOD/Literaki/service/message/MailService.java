package SKNI.KOD.Literaki.service.message;

import SKNI.KOD.Literaki.DTO.request.login.MailAttemptRequest;
import SKNI.KOD.Literaki.DTO.request.login.MailRequest;
import SKNI.KOD.Literaki.DTO.response.auth.MailAttemptResponse;
import SKNI.KOD.Literaki.config.YAMLConfiguration;
import SKNI.KOD.Literaki.service.logs.MailAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    @Autowired
    //don't trust IDE, this works lol
    private JavaMailSender javaMailSender;

    @Autowired
    private MailAttemptService mailAttemptService;

    @Autowired
    private YAMLConfiguration ymlCfg;


    public MailAttemptResponse sendTestMail(){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("Literaki.SKNI@gmail.com");
        mail.setSubject("Test message");
        mail.setText("Test");
        mail.setTo("Literaki.SKNI@gmail.com");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        MailAttemptRequest mailAttemptRequest = new MailAttemptRequest("Test",true,"Literaki.SKNI@gmail.com",currentPrincipalName);
        try {
            javaMailSender.send(mail);
        }catch (Exception e){
            mailAttemptRequest.setSuccessful(false);
            e.printStackTrace();
        }
        return mailAttemptService.createMailAttempt(mailAttemptRequest);
    }

    public MailAttemptResponse sendEmail(MailRequest mailRequest){
        MimeMessage mail = javaMailSender.createMimeMessage();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        try {
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
            mailHelper.setTo(mailRequest.getSendTo());
            mailHelper.setReplyTo(ymlCfg.getMail().getProjectMail());
            mailHelper.setFrom(ymlCfg.getMail().getProjectMail());
            mailHelper.setSubject(mailRequest.getTitle());
            mailHelper.setText(mailRequest.getContentString(),true);
            javaMailSender.send(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return mailAttemptService.createMailAttempt(new MailAttemptRequest(mailRequest,true,currentPrincipalName));
    }

}
