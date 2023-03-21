package SKNI.KOD.Literaki.entity.login;


import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(schema = "security", name = "verification_token")
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private ZonedDateTime expiryDate;
}
