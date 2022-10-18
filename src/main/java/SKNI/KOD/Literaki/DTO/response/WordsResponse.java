package SKNI.KOD.Literaki.DTO.response;

import SKNI.KOD.Literaki.entity.games.Words;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WordsResponse {
    private Long id;
    private Long gameId;
    private Long playerId;
    private int points;

    public WordsResponse(Words words) {
        this.gameId = words.getId();
        this.playerId = words.getPlayerId();
        this.points = words.getPoints();
    }

}
