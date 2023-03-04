package SKNI.KOD.Literaki.service.game;

import SKNI.KOD.Literaki.DTO.request.game.GameRequest;
import SKNI.KOD.Literaki.DTO.response.game.GameResponse;
import SKNI.KOD.Literaki.entity.game.Game;
import SKNI.KOD.Literaki.repository.game.GameRepository;
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

    public GameResponse getGame(Long id) {
        Game game = null;
        if (gameRepository.existsById(id)){
            game = gameRepository.findById(id).get();
        }
        return new GameResponse(game);
    }

    //TODO: uncomment this after creating Board
//    public GameResponse createGame(GameRequest gameRequest){
//its bad ->        Game game = new Game(gameRequest.player1, gameRequest.player2)
//                .setIdBoard(new Board(gameRequest.getId()));
//
//        return new GameResponse(game);
//    }

    public GameResponse updateGame(GameRequest gameRequest){
        Game game = null;
        if(gameRepository.existsById(gameRequest.getId())) {
            game = gameRepository.findById(gameRequest.getId()).get();
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
            Long winner = pct1 == pct2 ? null : (pct1 > pct2 ? game.getPlayerOne().getPlayerId() : game.getPlayerTwo().getPlayerId());
            oldGameService.saveOldGame(game, winner);
            gameRepository.delete(game);
        }
    }
}