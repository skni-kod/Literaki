package SKNI.KOD.Literaki.controller;

import SKNI.KOD.Literaki.entity.games.Game;
import SKNI.KOD.Literaki.repository.GameRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("games")
public class GamesController {

    private final GameRepository repository;

    public GamesController(GameRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/{id}")
    public Optional<Game> getGame(@PathVariable int id) {
        return repository.findById(Long.valueOf(id));
    }



}
