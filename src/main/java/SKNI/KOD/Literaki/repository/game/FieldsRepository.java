package SKNI.KOD.Literaki.repository.game;

import SKNI.KOD.Literaki.entity.game.Board;
import SKNI.KOD.Literaki.entity.game.Fields;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FieldsRepository extends JpaRepository<Fields, Long>  {

    List<Fields> findAll();
    List<Fields> findAll(Sort sort);
    List<Fields> findAllByBoard(Board board);
    Optional<Fields> findById(Long aLong);

    boolean existsById(Long aLong);
    void deleteById(Long aLong);
    void deleteAllByBoard(Board board);
}
