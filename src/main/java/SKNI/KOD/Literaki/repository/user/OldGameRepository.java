package SKNI.KOD.Literaki.repository.user;

import SKNI.KOD.Literaki.entity.user.OldGame;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OldGameRepository extends JpaRepository<OldGame, Long> {

    List<OldGame> findAll();
    List<OldGame> findAll(Sort sort);
    List<OldGame> findAllById(Iterable<Long> longs);
    Optional<OldGame> findById(Long aLong);

    boolean existsById(Long aLong);
    void deleteById(Long aLong);
    void deleteAllById(Iterable<? extends Long> longs);
}
