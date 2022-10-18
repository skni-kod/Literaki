package SKNI.KOD.Literaki.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

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
