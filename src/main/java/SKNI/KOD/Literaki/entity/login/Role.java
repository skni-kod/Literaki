package SKNI.KOD.Literaki.entity.login;

import SKNI.KOD.Literaki.util.ERole;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema="security", catalog = "proj")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column
    private ERole name;

    @Override
    public String toString(){
        return name.toString();
    }
}
