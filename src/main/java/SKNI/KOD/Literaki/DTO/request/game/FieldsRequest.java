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
public class FieldsRequest {
    @NotNull
    private Long fieldId;

    @NotNull
    private Long letterId;

    @NotNull
    private Double scoreMultiplier;

    @NotNull
    private Long playerId;

    @NotNull
    private Long boardId;
}
