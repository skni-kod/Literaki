package SKNI.KOD.Literaki.entity.game;

import SKNI.KOD.Literaki.entity.user.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "games", name="game")
public class Game {
    @Id
    @Column(unique = true, nullable = false, name="gameId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameID;


    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName ="playerId", nullable = false, insertable = false, updatable = false)
    private Profile playerOne;


    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName ="playerId", nullable = false, insertable = false, updatable = false)
    private Profile playerTwo;

    @Column(nullable = false)
    private int pointsPlayer1 = 0;

    @Column(nullable = false)
    private int pointsPlayer2 = 0;

    @Column(nullable = false)
    private boolean state = false;

    //TODO: fix when add Board table
//    @Embedded
//    private Long idBoard;


    public Game(Profile playerOne, Profile playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
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

    public Long getGameID() {
        return gameID;
    }

    public Profile getIdPlayer1() {
        return playerOne;
    }

    public Profile getIdPlayer2() {
        return playerTwo;
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

}
