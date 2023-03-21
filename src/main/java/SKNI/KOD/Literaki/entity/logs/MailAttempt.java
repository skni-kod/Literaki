package SKNI.KOD.Literaki.entity.logs;

import lombok.*;

import jakarta.persistence.*;
import java.time.ZonedDateTime;

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
    private ZonedDateTime attemptDate;

    @Column(nullable = true)
    private String requestingUser;

    @Column(nullable = false)
    private String sentTo;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, name = "successful")
    private Boolean isSuccessful;
}
