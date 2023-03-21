package SKNI.KOD.Literaki.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema="players", name="OldGames")
public class OldGame {

    @Id
    @Column(unique = true, nullable = false, name="oldGameId")
    private Long oldGameId;


    @OneToOne(optional = false)
    @JoinColumn(referencedColumnName ="playerId", nullable = false, insertable = false, updatable = false)
    private Profile player1;


    @OneToOne(optional = false)
    @JoinColumn(referencedColumnName ="playerId", nullable = false, insertable = false, updatable = false)
    private Profile player2;

    @Column(nullable = false)
    private int pointsPlayer1 = 0;

    @Column(nullable = false)
    private int pointsPlayer2 = 0;


    @Column(nullable = false)
    private Long result = null;


    public OldGame(Long oldGameId, Profile player1, Profile player2, int pointsPlayer1, int pointsPlayer2, boolean state, Long winner) {
        this.oldGameId = oldGameId;
        this.player1 = player1;
        this.player2 = player2;
        this.pointsPlayer1 = pointsPlayer1;
        this.pointsPlayer2 = pointsPlayer2;
        this.result = winner;
    }

    public Long getResult() {
        return result;
    }

    public Long getOldGameId() {
        return oldGameId;
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
