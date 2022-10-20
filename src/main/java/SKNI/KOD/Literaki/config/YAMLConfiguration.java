package SKNI.KOD.Literaki.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="default-config")
@Getter
@Setter
public class YAMLConfiguration {
    private final Mail mail = new Mail();
    
    @Getter
    @Setter
    public static class Mail{
            private String projectMail;
    }
}
