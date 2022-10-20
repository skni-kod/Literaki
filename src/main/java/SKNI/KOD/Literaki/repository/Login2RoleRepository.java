package SKNI.KOD.Literaki.repository;

import SKNI.KOD.Literaki.entity.login.LoginRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Login2RoleRepository extends JpaRepository<LoginRole,String> {
}
