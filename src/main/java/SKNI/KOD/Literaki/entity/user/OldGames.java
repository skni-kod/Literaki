package SKNI.KOD.Literaki.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema="Games", catalog = "proj", name="OldGames")
public class OldGames {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(schema = "security", name = "login")
    @JoinColumn(referencedColumnName = "id")
    private Profile player1;

    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(schema = "security", name = "login")
    @JoinColumn(referencedColumnName = "id")
    private Profile player2;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "Games", name = "Board")
    @JoinColumn(referencedColumnName = "id")
    private int pointsPlayer1 = 0;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "Games", name = "Board")
    @JoinColumn(referencedColumnName = "id")
    private int pointsPlayer2 = 0;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "security", name = "security")
    @JoinColumn(referencedColumnName = "id")
    private Long result = null;


    public OldGames(Long id, Profile player1, Profile player2, int pointsPlayer1, int pointsPlayer2, boolean state, Long winner) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.pointsPlayer1 = pointsPlayer1;
        this.pointsPlayer2 = pointsPlayer2;
        this.result = winner;
    }

    public Long getResult() {
        return result;
    }

    public Long getId() {
        return id;
    }

    public Profile getPlayer1() {
        return player1;
    }

    public Profile getPlayer2() {
        return player2;
    }

    public int getPointsPlayer1() {
        return pointsPlayer1;
    }

    public int getPointsPlayer2() {
        return pointsPlayer2;
    }


}
