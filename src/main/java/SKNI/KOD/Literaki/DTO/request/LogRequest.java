package SKNI.KOD.Literaki.DTO.request;

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
