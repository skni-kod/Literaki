package SKNI.KOD.Literaki.service.security;

import SKNI.KOD.Literaki.DTO.request.AuthRequest;
import SKNI.KOD.Literaki.DTO.response.AuthResponse;
import SKNI.KOD.Literaki.config.security.JWTTokenProvider;
import SKNI.KOD.Literaki.config.security.UserDetailsImpl;
import SKNI.KOD.Literaki.repository.LoginRepository;
import SKNI.KOD.Literaki.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {
    @Autowired
    LoginRepository loginRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTTokenProvider jwtTokenProvider;

    public AuthResponse getAuthToken(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetailsImpl.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return new AuthResponse(userDetailsImpl.getId(), jwt, userDetailsImpl.getUsername(), userDetailsImpl.getEmail(), roles);
    }
}
