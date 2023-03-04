package SKNI.KOD.Literaki.entity.game;

import SKNI.KOD.Literaki.entity.user.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "games", name="word_bag")
public class WordBag {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wordBagId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName ="playerId", nullable = false, insertable = false, updatable = false)
    private Profile playerId;

    @OneToMany
    private List<Letter> wordBagLetters;
}
