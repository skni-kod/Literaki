package SKNI.KOD.Literaki.controller;

import SKNI.KOD.Literaki.DTO.request.LogRequest;
import SKNI.KOD.Literaki.DTO.response.LogResponse;
import SKNI.KOD.Literaki.service.logs.LogService;
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
}
