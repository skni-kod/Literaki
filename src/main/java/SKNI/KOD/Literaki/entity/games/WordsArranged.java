package SKNI.KOD.Literaki.entity.games;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema="Games", catalog = "proj", name="Words")
public class WordsArranged {
    public WordsArranged(Long gameId, Long playerId) {
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(schema = "Games", name = "Games")
    @JoinColumn(referencedColumnName = "id")
    private Long gameId;

    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(schema = "security", name = "login")
    @JoinColumn(referencedColumnName = "id")
    private Long playerId;

    //TODO: uncomment when Field entity created
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(schema = "Games", name = "Fields")
//    @JoinColumn(referencedColumnName = "id")
//    private List<Field> fieldlist = new ArrayList<Field>();

    @Column(nullable = false)
    private int points = 0;
    
}
