package SKNI.KOD.Literaki.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse {
    private Long id;
    private String username;
    private byte icon;
    private int ranking;
    private Timestamp creationDate;
}
