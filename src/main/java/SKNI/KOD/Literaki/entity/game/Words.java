package SKNI.KOD.Literaki.entity.game;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema="games", name="words")
public class Words {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name="wordsId")
    private Long id;

    @JoinColumn(referencedColumnName ="gameId", nullable = false)
    private Long gameId;

    @JoinColumn(referencedColumnName ="playerId", nullable = false)
    private Long playerId;

    //TODO: fix  when Field entity created
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(table="Games.Fields", name="id", nullable = false)
//    private List<Field> fieldlist = new ArrayList<Field>();

    @Column(nullable = false)
    private int points = 0;


    public Words(Long gameId, Long playerId) {
        this.gameId = gameId;
        this.playerId = playerId;
        //TODO: uncomment when Field entity created
        //this.fieldlist = new ArrayList<Field>();
        this.points = 0;
    }

    public Long getId() {
        return id;
    }

    public Long getGameId() {
        return gameId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    //TODO: uncomment when Field entity created
//    public List<Field> getFieldlist() {
//        return fieldlist;
//    }

    public int getPoints() {
        return points;
    }

    //TODO: uncomment when Field entity created
//    public void setFieldlist(List<Field> fieldlist) {
//        this.fieldlist = fieldlist;
//    }

    public void setPoints(int points) {
        this.points = points;
    }
}
