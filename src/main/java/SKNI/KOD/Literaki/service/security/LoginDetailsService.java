package SKNI.KOD.Literaki.service.security;

import SKNI.KOD.Literaki.config.security.UserDetailsImpl;
import SKNI.KOD.Literaki.entity.login.Login;
import SKNI.KOD.Literaki.repository.login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Locale;

@Service
public class LoginDetailsService implements UserDetailsService {
    @Autowired
    private LoginRepository loginRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepository.findByUsername(username.toLowerCase(Locale.ROOT))
                .orElseThrow(() -> new ExpressionException("User Not Found"));
        return UserDetailsImpl.build(login);
    }
}
