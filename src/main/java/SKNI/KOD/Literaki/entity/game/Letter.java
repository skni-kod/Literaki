package SKNI.KOD.Literaki.entity.game;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "games", name="letter")
public class Letter {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterId;


    @Column(nullable = false)
    //really don't want to use chars for it
    private String character;

    @Column(nullable = false)
    private Integer score;
}
