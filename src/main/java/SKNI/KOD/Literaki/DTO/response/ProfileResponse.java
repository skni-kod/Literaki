package SKNI.KOD.Literaki.DTO.response;

import SKNI.KOD.Literaki.entity.user.Profile;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class ProfileResponse {
    private Long id;
    private String username;
    private byte icon;
    private int ranking;
    private Timestamp creationDate;

    public ProfileResponse(Profile profile) {
        this.id = profile.getPlayerId();
        this.username = profile.getUsername();
        this.icon = profile.getIcon();
        this.ranking = profile.getRanking();
        this.creationDate = profile.getCreationDate();
    }
}
