package SKNI.KOD.Literaki.DTO.response.game;

import SKNI.KOD.Literaki.entity.game.Letter;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Setter
@Getter
public class LetterResponse {
    @NotNull
    private Long letterId;
    @NotNull
    private String character;
    @NotNull
    private Integer score;

    public LetterResponse(Letter letter) {
        this.letterId = letter.getLetterId();
        this.character = letter.getCharacter();
        this.score = letter.getScore();
    }
}
