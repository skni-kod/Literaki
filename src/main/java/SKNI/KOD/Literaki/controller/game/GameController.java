package SKNI.KOD.Literaki.controller.game;

import SKNI.KOD.Literaki.DTO.request.game.GameRequest;
import SKNI.KOD.Literaki.DTO.response.game.GameResponse;
import SKNI.KOD.Literaki.service.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("")
    public List<GameResponse> getGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public GameResponse getGame(@PathVariable Long id) {
        return gameService.getGame(id);
    }

    //@PostMapping("/games/create")
    //public ResponseEntity<?> createGame(GameRequest gameRequest){
        //TODO: UNCOMMENT AFTER IMPLEMENTING BOARD
        //GameResponse gameResponse = gameService.createGame(gameRequest);
        //return ResponseEntity.ok(gameResponse);
    //}

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateGame(GameRequest gameRequest){
        GameResponse gameResponse = gameService.updateGame(gameRequest);
        return ResponseEntity.ok(gameResponse);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> finishGame(@PathVariable Long id){
        gameService.finishGame(id);
        return ResponseEntity.ok().build();
    }

}
