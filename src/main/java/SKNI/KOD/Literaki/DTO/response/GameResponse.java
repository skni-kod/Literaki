package SKNI.KOD.Literaki.DTO.response;

import SKNI.KOD.Literaki.entity.games.Game;
import SKNI.KOD.Literaki.entity.user.Profile;
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
    private Profile player1;
    private Profile player2;
    private int pointsPlayer1;
    private int pointsPlayer2;
    private boolean state;
    private Long idBoard;

    public GameResponse(Game game) {
        this.id = game.getId();
        this.player1 = game.getPlayer1();
        this.player2 = game.getPlayer2();
        this.pointsPlayer1 = game.getPointsPlayer1();
        this.pointsPlayer2 = game.getPointsPlayer2();
        this.state = game.isState();
        this.idBoard = game.getIdBoard();
    }
}