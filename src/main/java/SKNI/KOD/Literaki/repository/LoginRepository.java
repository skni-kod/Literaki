package SKNI.KOD.Literaki.repository;

import SKNI.KOD.Literaki.entity.login.Login;
import SKNI.KOD.Literaki.entity.login.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository  extends JpaRepository<Login,String> {
    Optional<Login> findByUsername(String username);
    Optional<Login> findByUsernameIgnoreCase(String username);
    Optional<Login> findByEmail(String email);
    Optional<Login> findByUsernameOrEmail(String username, String email);

    boolean existsByUsername(String usernameOrEmail);
    Optional<Login> findByVerificationToken (VerificationToken verificationToken);
}
