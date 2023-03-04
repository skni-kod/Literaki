package SKNI.KOD.Literaki.DTO.request.login;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogRequest {
    private String requestingIP;
    private String description;
}
