package SKNI.KOD.Literaki.DTO.response.user;

import SKNI.KOD.Literaki.entity.user.Profile;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
public class ProfileResponse {
    private Long id;
    private String username;
    private byte icon;
    private int ranking;
    private ZonedDateTime creationDate;

    public ProfileResponse(Profile profile) {
        this.id = profile.getPlayerId();
        this.username = profile.getUsername();
        try{
            this.icon = profile.getIcon();
        }catch (NullPointerException e){};
        this.ranking = profile.getRanking();
        this.creationDate = profile.getCreationDate();
    }
}
