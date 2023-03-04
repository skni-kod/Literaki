package SKNI.KOD.Literaki.DTO.response.game;

import SKNI.KOD.Literaki.entity.game.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GameResponse {
    private Long id;
    private Long player1;
    private Long player2;
    private int pointsPlayer1;
    private int pointsPlayer2;
    private boolean state;
    //private Long idBoard;

    public GameResponse(Game game) {
        this.id = game.getGameID();
        this.player1 = game.getPlayerOne().getPlayerId();
        this.player2 = game.getPlayerTwo().getPlayerId();
        this.pointsPlayer1 = game.getPointsPlayer1();
        this.pointsPlayer2 = game.getPointsPlayer2();
        this.state = game.isState();
        //this.idBoard = game.getIdBoard();
    }
}
