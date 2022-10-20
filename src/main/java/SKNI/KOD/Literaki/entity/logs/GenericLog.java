package SKNI.KOD.Literaki.entity.logs;

import SKNI.KOD.Literaki.util.ELogType;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "logs", name = "logs")
public class GenericLog {
    //id,type,whoAttempted,his_ip,log_message,time
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private ZonedDateTime attemptDate;

    @Column(nullable = false)
    private String requestingIP;

    @Column(nullable = true)
    private String requestingUser;

    @Column(nullable = false)
    private ELogType type;

    @Column(nullable = true)
    private String description;
}
