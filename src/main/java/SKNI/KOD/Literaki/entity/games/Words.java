package SKNI.KOD.Literaki.entity.games;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema="games", name="words")
@SecondaryTables({@SecondaryTable(name = "games.games"), @SecondaryTable(name="user.profile")})
public class Words {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @JoinColumn(table="games.games", name="id", nullable = false)
    private Long gameId;

    @JoinColumn(table="user.profile", name="id", nullable = false)
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
