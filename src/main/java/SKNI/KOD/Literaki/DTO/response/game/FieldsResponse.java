package SKNI.KOD.Literaki.DTO.response.game;

import SKNI.KOD.Literaki.entity.game.Board;
import SKNI.KOD.Literaki.entity.game.Fields;
import SKNI.KOD.Literaki.entity.game.Letter;
import SKNI.KOD.Literaki.entity.user.Profile;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class FieldsResponse {
    @NotNull
    private Long fieldId;

    @NotNull
    private Letter letter;

    @NotNull
    private Double scoreMultiplier;

    @NotNull
    private Profile player;

    @NotNull
    private Board board;

    public FieldsResponse(Fields field) {
        this.fieldId = field.getFieldId();
        this.letter = field.getLetter();
        this.scoreMultiplier = field.getScoreMultiplier();
        this.player = field.getPlayer();
        this.board = field.getBoard();
    }
}
