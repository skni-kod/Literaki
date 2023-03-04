package SKNI.KOD.Literaki.repository.game;

import SKNI.KOD.Literaki.entity.game.Board;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAll();
    List<Board> findAll(Sort sort);
    List<Board> findAllById(Iterable<Long> longs);
    Optional<Board> findById(Long aLong);

    boolean existsById(Long aLong);
    void deleteById(Long aLong);
}