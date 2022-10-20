package SKNI.KOD.Literaki.DTO.response;


import SKNI.KOD.Literaki.entity.logs.GenericLog;
import SKNI.KOD.Literaki.util.ELogType;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogResponse {
    private ZonedDateTime attemptDate;
    private String requestingIP;
    private String requestingUser;
    private String type;
    private String description;

    public LogResponse(GenericLog log) {
        attemptDate = log.getAttemptDate();
        requestingIP = log.getRequestingIP();
        requestingUser = log.getRequestingUser();
        type = log.getType().name();
        description = log.getDescription();
    }
}
