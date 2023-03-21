package SKNI.KOD.Literaki.config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final AuthenticationException e) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
    }
}
