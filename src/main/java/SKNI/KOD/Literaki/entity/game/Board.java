package SKNI.KOD.Literaki.entity.game;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "games", name="board")
public class Board {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @OneToMany
    private List<Fields> fields;

    @OneToOne
    @JoinColumn(name = "board_word_bag_word_bag_id")
    private WordBag boardWordBag;

    @OneToOne
    @JoinColumn(name = "player_one_word_bag_word_bag_id")
    private WordBag playerOneWordBag;
    @Column(nullable = false)
    private Double playerOneScore;

    @OneToOne
    @JoinColumn(name = "player_two_word_bag_word_bag_id")
    private WordBag playerTwoWordBag;
    @Column(nullable = false)
    private Double playerTwoScore;
}
