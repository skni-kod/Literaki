package SKNI.KOD.Literaki.DTO.request.game;

import SKNI.KOD.Literaki.entity.user.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameRequest {
    private Profile player1;
    private Profile player2;
    private int pointsPlayer1;
    private int pointsPlayer2;
    private boolean state;

    @NotNull
    private Long id;
}
