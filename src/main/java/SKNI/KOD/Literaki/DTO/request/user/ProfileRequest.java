package SKNI.KOD.Literaki.DTO.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest {
    private String username;
    private byte icon;
    private int ranking;
    private ZonedDateTime creationDate;
    @NotNull
    private Long id;
}