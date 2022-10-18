package SKNI.KOD.Literaki.entity.games;

import SKNI.KOD.Literaki.entity.user.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema="Games", catalog = "proj", name="Games")
public class Game {
    public Game(Profile player1, Profile player2) {
        this.player1 = player1;
        this.player2 = player2;
        //TODO: here should be called constructor of Board and returned to this.idBoard
    }

    public void setPointsPlayer1(int pointsPlayer1) {
        this.pointsPlayer1 = pointsPlayer1;
    }

    public void setPointsPlayer2(int pointsPlayer2) {
        this.pointsPlayer2 = pointsPlayer2;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public Profile getIdPlayer1() {
        return player1;
    }

    public Profile getIdPlayer2() {
        return player2;
    }

    public int getPointsPlayer1() {
        return pointsPlayer1;
    }

    public int getPointsPlayer2() {
        return pointsPlayer2;
    }

    public boolean isState() {
        return state;
    }

    public Long getIdBoard() {
        return idBoard;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "security", name = "login")
    @JoinColumn(referencedColumnName = "id")
    private Profile player1;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "security", name = "login")
    @JoinColumn(referencedColumnName = "id")
    private Profile player2;

    @Column(nullable = false)
    private int pointsPlayer1 = 0;

    @Column(nullable = false)
    private int pointsPlayer2 = 0;

    @Column(nullable = false)
    private boolean state = false;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "Games", name = "Board")
    @JoinColumn(referencedColumnName = "id")
    private Long idBoard;
}
