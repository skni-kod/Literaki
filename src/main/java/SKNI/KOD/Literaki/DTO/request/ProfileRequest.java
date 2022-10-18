package SKNI.KOD.Literaki.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest {
    private String username;
    private byte icon;
    private int ranking;
    private Timestamp creationDate;
    @NotNull
    private Long id;
}