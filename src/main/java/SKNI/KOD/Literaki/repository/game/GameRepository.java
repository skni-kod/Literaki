package SKNI.KOD.Literaki.repository.game;

import SKNI.KOD.Literaki.entity.game.Game;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAll();
    List<Game> findAll(Sort sort);
    List<Game> findAllById(Iterable<Long> longs);
    Optional<Game> findById(Long aLong);

    boolean existsById(Long aLong);
    void deleteById(Long aLong);
    void deleteAllById(Iterable<? extends Long> longs);
}