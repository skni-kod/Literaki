package SKNI.KOD.Literaki.entity.login;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
}, schema = "security", name = "login")
@Builder

public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(schema = "security", name = "login_roles",
            joinColumns = @JoinColumn(name = "login_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Builder.Default
    private Set<Role> roles = new HashSet<>();
    @Column(nullable = false)
    @Builder.Default
    private Boolean verified = false;
    @Column
    @Builder.Default
    private Boolean isDeleted = false;
    @OneToOne(targetEntity = VerificationToken.class, fetch = FetchType.EAGER,optional = true)
    private VerificationToken verificationToken;

    public Login(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
