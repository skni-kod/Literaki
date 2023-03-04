package SKNI.KOD.Literaki.repository.game;

import SKNI.KOD.Literaki.entity.game.Letter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Long> {

    List<Letter> findAll();
    List<Letter> findAll(Sort sort);
    List<Letter> findAllById(Iterable<Long> longs);
    Optional<Letter> findById(Long aLong);

    boolean existsById(Long aLong);
    void deleteById(Long aLong);
}
