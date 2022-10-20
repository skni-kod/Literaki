package SKNI.KOD.Literaki.entity.logs;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(schema = "logs", name = "mail_attempts")
public class MailAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private Timestamp attemptDate;

    @Column(nullable = true)
    private String requestingUser;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false, name = "successful")
    private Boolean isSuccessful;
}
