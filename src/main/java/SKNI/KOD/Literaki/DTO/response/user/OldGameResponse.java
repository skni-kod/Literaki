package SKNI.KOD.Literaki.DTO.response.user;

import SKNI.KOD.Literaki.entity.user.OldGame;
import SKNI.KOD.Literaki.entity.user.Profile;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OldGameResponse {
    private Long id;
    private Long player1;
    private Long player2;
    private int pointsPlayer1;
    private int pointsPlayer2;
    private Long result;

    public OldGameResponse(OldGame oldGame) {
        this.id = oldGame.getOldGameId();
        this.player1 = oldGame.getPlayer1().getPlayerId();
        this.player2 = oldGame.getPlayer2().getPlayerId();
        this.pointsPlayer1 = oldGame.getPointsPlayer1();
        this.pointsPlayer2 = oldGame.getPointsPlayer2();
        this.result = oldGame.getResult();
    }

}
