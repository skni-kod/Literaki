package SKNI.KOD.Literaki.DTO.response;

import SKNI.KOD.Literaki.entity.user.OldGame;
import SKNI.KOD.Literaki.entity.user.Profile;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OldGameResponse {
    private Long id;
    private Profile player1;
    private Profile player2;
    private int pointsPlayer1;
    private int pointsPlayer2;
    private Long result;

    public OldGameResponse(OldGame oldGame) {
        this.id = oldGame.getId();
        this.player1 = oldGame.getPlayer1();
        this.player2 = oldGame.getPlayer2();
        this.pointsPlayer1 = oldGame.getPointsPlayer1();
        this.pointsPlayer2 = oldGame.getPointsPlayer2();
        this.result = oldGame.getResult();
    }

}
