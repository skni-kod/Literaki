package SKNI.KOD.Literaki.repository;

import SKNI.KOD.Literaki.entity.login.Role;
import SKNI.KOD.Literaki.util.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
