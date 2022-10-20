package SKNI.KOD.Literaki.controller;

import SKNI.KOD.Literaki.DTO.request.LoginRequest;
import SKNI.KOD.Literaki.DTO.response.LoginResponse;
import SKNI.KOD.Literaki.service.security.LoginService;
import SKNI.KOD.Literaki.util.HttpServletRequestResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

//    @GetMapping
//    public void testMappings(HttpServletRequest httpServletRequest){
//        System.out.printf("Servlet path: %20s%n",httpServletRequest.getServletPath());
//        System.out.printf("Http servlet mapping: %20s%n",httpServletRequest.getHttpServletMapping().getPattern());
//        System.out.printf("Context path: %20s%n",httpServletRequest.getContextPath());
//        System.out.printf("Path translated: %20s%n",httpServletRequest.getPathTranslated());
//        System.out.printf("Path info: %20s%n",httpServletRequest.getPathInfo());
//        System.out.printf("Request uri: %20s%n",httpServletRequest.getRequestURI());
//        System.out.printf("Request url: %20s%n",httpServletRequest.getRequestURL());
//        System.out.printf("Build try: %20s%n", HttpServletRequestResolver.getServerPathFromRequest(httpServletRequest));
//    }

    @RequestMapping("/create")
    public ResponseEntity<LoginResponse> createLogin(LoginRequest loginRequest, HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(loginService.createLogin(loginRequest,httpServletRequest));
    }

    @RequestMapping("/verify/{token}")
    public ResponseEntity<LoginResponse> verifyLogin(@PathVariable("token") String token){
        return ResponseEntity.ok(loginService.verifyLogin(token));
    }
}
