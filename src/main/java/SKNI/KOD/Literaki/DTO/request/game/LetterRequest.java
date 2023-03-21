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
public class LetterRequest {
    @NotNull
    private Long letterId;
    @NotNull
    private String character;
    @NotNull
    private Integer score;
}
