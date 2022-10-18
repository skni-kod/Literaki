package SKNI.KOD.Literaki.DTO.response;

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
}
