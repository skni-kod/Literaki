package SKNI.KOD.Literaki.DTO.request.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WordsRequest {
    private Long gameId;
    private Long playerId;
    private int points;
    @NotNull
    private Long id;
}
