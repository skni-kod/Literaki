package SKNI.KOD.Literaki.service.games;

import SKNI.KOD.Literaki.DTO.request.GameRequest;
import SKNI.KOD.Literaki.DTO.response.GameResponse;
import SKNI.KOD.Literaki.entity.games.Game;
import SKNI.KOD.Literaki.repository.GameRepository;
import SKNI.KOD.Literaki.service.user.OldGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameResponse> getAllGames() {
        return gameRepository.findAll().stream()
                .map(GameResponse::new)
                .collect(Collectors.toList());
    }

    public GameResponse getGame(Long id){
        Game game = gameRepository.findById(id).get();
        return new GameResponse(game);
    }

    //TODO: uncomment this after creating Board
//    public GameResponse createGame(GameRequest gameRequest){
//        Game game = new Game(gameRequest.player1, gameRequest.player2)
//                .setIdBoard(new Board(gameRequest.getId()));
//
//        return new GameResponse(game);
//    }

    public GameResponse updateGame(GameRequest gameRequest, Long id){
        Game game = null;
        if(gameRepository.existsById(id)) {
            game = gameRepository.findById(id).get();
            game.setPointsPlayer1(gameRequest.getPointsPlayer1());
            game.setPointsPlayer2(gameRequest.getPointsPlayer2());
            game.setState(gameRequest.isState());
        }
        return new GameResponse(game);
    }

    public void finishGame(Long id){
        if(gameRepository.existsById(id)) {
            Game game = gameRepository.findById(id).get();
            OldGameService oldGameService = new OldGameService();
            Long pct1 = Long.valueOf(game.getPointsPlayer1());
            Long pct2 = Long.valueOf(game.getPointsPlayer2());
            Long winner = pct1 == pct2 ? null : (pct1 > pct2 ? game.getPlayer1().getId() : game.getPlayer2().getId());
            oldGameService.saveOldGame(game, winner);
            gameRepository.delete(game);
        }
    }
}