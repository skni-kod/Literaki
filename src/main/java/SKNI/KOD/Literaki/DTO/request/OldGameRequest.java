package SKNI.KOD.Literaki.DTO.request;

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
public class OldGameRequest {
    @NotNull
    private Long id;
    private Profile player1;
    private Profile player2;
    private int pointsPlayer1;
    private int pointsPlayer2;
    private Long result;
}
