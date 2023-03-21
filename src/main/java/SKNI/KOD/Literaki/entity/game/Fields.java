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
@Table(schema = "games", name="game_fields")
public class Fields {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fieldId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName ="letterId", nullable = false, insertable = false, updatable = false)
    private Letter letter;

    @Column(nullable = false)
    private Double scoreMultiplier;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName ="playerId", nullable = false, insertable = false, updatable = false)
    private Profile player;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName ="boardId", nullable = false, insertable = false, updatable = false)
    private Board board;

}
