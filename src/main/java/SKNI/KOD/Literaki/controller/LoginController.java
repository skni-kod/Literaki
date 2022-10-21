package SKNI.KOD.Literaki.controller;

import SKNI.KOD.Literaki.DTO.request.ChangePasswordRequest;
import SKNI.KOD.Literaki.DTO.request.LoginRequest;
import SKNI.KOD.Literaki.DTO.response.LoginResponse;
import SKNI.KOD.Literaki.service.security.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/create")
    public ResponseEntity<LoginResponse> createLogin(LoginRequest loginRequest, HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(loginService.createLogin(loginRequest,httpServletRequest));
    }

    @PostMapping("/verify/{token}")
    public ResponseEntity<LoginResponse> verifyLogin(@PathVariable("token") String token, HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(loginService.verifyLogin(token));
    }

    @PostMapping("/changePassword")
    public ResponseEntity<LoginResponse> changePassword(ChangePasswordRequest changePasswordRequest,HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(loginService.changePassword(changePasswordRequest,httpServletRequest));
    }

    @PostMapping("/forgotPassword")
    public ResponseEntity<LoginResponse> forgotPassword(String email,HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(loginService.forgotPassword(email,httpServletRequest));
    }
    @PostMapping("/resetPassword/{token}")
    public ResponseEntity<LoginResponse> resetPassword(@PathVariable("token") String token,String password,HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(loginService.resetPassword(token,password,httpServletRequest));
    }
}
