package SKNI.KOD.Literaki.DTO.response.game;

import SKNI.KOD.Literaki.entity.game.Board;
import SKNI.KOD.Literaki.entity.game.Fields;
import SKNI.KOD.Literaki.entity.game.WordBag;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class BoardResponse {
    @NotNull
    private Long boardId;
    private List<Fields> fields;
    private WordBag boardWordBag;
    private WordBag playerOneWordBag;
    @NotNull
    private Double playerOneScore;
    private WordBag playerTwoWordBag;
    @NotNull
    private Double playerTwoScore;

    public BoardResponse(Board board) {
        this.boardId = board.getBoardId();
        this.fields = board.getFields();
        this.boardWordBag = board.getBoardWordBag();
        this.playerOneWordBag = board.getPlayerOneWordBag();
        this.playerOneScore = board.getPlayerOneScore();
        this.playerTwoWordBag = board.getPlayerTwoWordBag();
        this.playerTwoScore = board.getPlayerTwoScore();
    }
}
