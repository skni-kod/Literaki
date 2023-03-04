package SKNI.KOD.Literaki.repository.login;

import SKNI.KOD.Literaki.entity.logs.GenericLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<GenericLog,Long> {
}
