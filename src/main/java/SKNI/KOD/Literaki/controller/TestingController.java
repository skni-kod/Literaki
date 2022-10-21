package SKNI.KOD.Literaki.controller;

import SKNI.KOD.Literaki.DTO.request.LogRequest;
import SKNI.KOD.Literaki.DTO.response.LogResponse;
import SKNI.KOD.Literaki.service.logs.LogService;
import SKNI.KOD.Literaki.service.message.MailService;
import SKNI.KOD.Literaki.util.HttpServletRequestResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/testing")
public class TestingController {
    @Autowired
    private LogService logService;

    @GetMapping("/testLog")
    public ResponseEntity<LogResponse> createTestLog(HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(logService.createInfoLog(new LogRequest(httpServletRequest.getRemoteAddr(),"Test logs")));
    }

    @Autowired
    private MailService mailService;

    @GetMapping("/mail")
    public ResponseEntity<?> sendTestMail(){
        return ResponseEntity.ok(mailService.sendTestMail());
    }

    @GetMapping("/requestPaths")
    public void testMappings(HttpServletRequest httpServletRequest){
        System.out.printf("Servlet path: %20s%n",httpServletRequest.getServletPath());
        System.out.printf("Http servlet mapping: %20s%n",httpServletRequest.getHttpServletMapping().getPattern());
        System.out.printf("Context path: %20s%n",httpServletRequest.getContextPath());
        System.out.printf("Path translated: %20s%n",httpServletRequest.getPathTranslated());
        System.out.printf("Path info: %20s%n",httpServletRequest.getPathInfo());
        System.out.printf("Request uri: %20s%n",httpServletRequest.getRequestURI());
        System.out.printf("Request url: %20s%n",httpServletRequest.getRequestURL());
        System.out.printf("Build try: %20s%n", HttpServletRequestResolver.getServerPathFromRequest(httpServletRequest));
    }
}
