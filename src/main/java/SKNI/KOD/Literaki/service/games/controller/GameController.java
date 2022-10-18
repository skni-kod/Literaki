package SKNI.KOD.Literaki.service.games.controller;

import SKNI.KOD.Literaki.DTO.response.GameResponse;
import SKNI.KOD.Literaki.service.games.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/{id}")
    public List<GameResponse> getGame(@PathVariable Long id) {
        return gameService.getAllGames();
    }



}
