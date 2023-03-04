package SKNI.KOD.Literaki.repository.login;

import SKNI.KOD.Literaki.entity.logs.MailAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailAttemptRepository extends JpaRepository<MailAttempt,Long> {
}
