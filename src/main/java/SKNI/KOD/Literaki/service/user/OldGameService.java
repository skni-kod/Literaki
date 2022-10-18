package SKNI.KOD.Literaki.service.user;

import SKNI.KOD.Literaki.DTO.response.OldGameResponse;
import SKNI.KOD.Literaki.entity.games.Game;
import SKNI.KOD.Literaki.entity.user.OldGame;
import SKNI.KOD.Literaki.repository.OldGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OldGameService {

    @Autowired
    private OldGameRepository oldGameRepository;

    public List<OldGameResponse> getAllOldGames() {
        return oldGameRepository.findAll().stream()
                .map(OldGameResponse::new)
                .collect(Collectors.toList());
    }

    public OldGameResponse getOldGame(Long id){
        OldGame oldGame = null;
        if(oldGameRepository.existsById(id))
            oldGame = oldGameRepository.findById(id).get();
        return new OldGameResponse(oldGame);
    }

    public OldGameResponse saveOldGame(Game game, Long winner){
        OldGame oldGame = new OldGame(game.getGameID(), game.getPlayerOne(), game.getPlayerTwo(), game.getPointsPlayer1(), game.getPointsPlayer2(), true, winner);
        return new OldGameResponse(oldGame);
    }

    public void deleteOldGame(Long id){
        OldGame oldGame = null;
        if(oldGameRepository.existsById(id)) {
            oldGame = oldGameRepository.findById(id).get();
            oldGameRepository.delete(oldGame);

        }
    }
}