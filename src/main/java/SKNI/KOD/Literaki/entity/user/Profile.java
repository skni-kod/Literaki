package SKNI.KOD.Literaki.entity.user;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "players", name="profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "playerId")
    @JoinColumn(table="login", nullable = false)
    private Long playerId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column()
    private Byte icon=0;

    @Column(nullable = false)
    private int ranking = 1000;

    @Column(nullable = false)
    private Timestamp creationDate = Timestamp.valueOf(LocalDateTime.now());

    public Profile(Long playerId, String username) {
        this.playerId = playerId;
        this.username = username;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte getIcon() {
        return icon;
    }

    public void setIcon(byte icon) {
        this.icon = icon;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
