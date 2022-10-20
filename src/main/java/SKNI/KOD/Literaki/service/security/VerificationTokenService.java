package SKNI.KOD.Literaki.service.security;

import SKNI.KOD.Literaki.entity.login.VerificationToken;
import SKNI.KOD.Literaki.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class VerificationTokenService {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    public ZonedDateTime calculateExpiryDate(){
        return ZonedDateTime.now().plus(1, ChronoUnit.DAYS);
    }

    public VerificationToken createVerificationToken(){
        VerificationToken verificationToken = VerificationToken.builder()
                .token(UUID.randomUUID().toString())
                .expiryDate(calculateExpiryDate())
                .build();
        return verificationTokenRepository.save(verificationToken);
    }
}
