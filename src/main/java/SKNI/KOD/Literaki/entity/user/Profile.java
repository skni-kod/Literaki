package SKNI.KOD.Literaki.entity.user;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema="user", catalog = "proj")
public class Profile {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "security", name = "login")
    @JoinColumn(referencedColumnName = "id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column()
    private byte icon;

    @Column(nullable = false)
    private int ranking = 1000;

    @Column(nullable = false)
    private Timestamp crationDate = Timestamp.valueOf(LocalDateTime.now());

    public Profile(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getCrationDate() {
        return crationDate;
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