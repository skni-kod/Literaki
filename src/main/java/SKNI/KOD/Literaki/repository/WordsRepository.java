package SKNI.KOD.Literaki.repository;

import SKNI.KOD.Literaki.entity.games.Words;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WordsRepository extends JpaRepository<Words, Long> {

    List<Words> findAll();
    List<Words> findAll(Sort sort);
    List<Words> findAllById(Iterable<Long> longs);
    Optional<Words> findById(Long aLong);

    boolean existsById(Long aLong);
    void deleteById(Long aLong);
    void deleteAllById(Iterable<? extends Long> longs);
}