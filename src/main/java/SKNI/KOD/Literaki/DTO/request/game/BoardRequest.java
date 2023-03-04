package SKNI.KOD.Literaki.DTO.request.game;

import SKNI.KOD.Literaki.entity.game.Fields;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequest {
    @NotNull
    private Long boardId;
    private List<Fields> fields;
    private Long boardWordBagId;
    private Long playerOneWordBagId;
    @NotNull
    private Double playerOneScore;
    private Long playerTwoWordBagId;
    @NotNull
    private Double playerTwoScore;
}
