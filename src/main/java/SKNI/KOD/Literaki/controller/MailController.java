package SKNI.KOD.Literaki.controller;

import SKNI.KOD.Literaki.service.message.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping("/test")
    public ResponseEntity<?> sendTestMail(){
        mailService.sendTestMail();
        return ResponseEntity.ok().build();
    }
}
