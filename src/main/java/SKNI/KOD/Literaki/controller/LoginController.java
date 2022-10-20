package SKNI.KOD.Literaki.controller;

import SKNI.KOD.Literaki.DTO.request.LoginRequest;
import SKNI.KOD.Literaki.DTO.response.LoginResponse;
import SKNI.KOD.Literaki.service.security.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/create")
    public ResponseEntity<LoginResponse> createLogin(LoginRequest loginRequest){
        return ResponseEntity.ok(loginService.createLogin(loginRequest));
    }

    @RequestMapping("/verify/{token}")
    public ResponseEntity<LoginResponse> verifyLogin(LoginRequest loginRequest, @PathVariable("token") String token){
        return ResponseEntity.ok(loginService.verifyLogin(loginRequest,token));
    }
}
