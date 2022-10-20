package SKNI.KOD.Literaki.service.logs;

import SKNI.KOD.Literaki.DTO.request.LogRequest;
import SKNI.KOD.Literaki.DTO.response.LogResponse;
import SKNI.KOD.Literaki.entity.logs.GenericLog;
import SKNI.KOD.Literaki.repository.LogRepository;
import SKNI.KOD.Literaki.util.ELogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public LogResponse createInfoLog(LogRequest logRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        GenericLog genericLog = GenericLog.builder()
                .attemptDate(ZonedDateTime.now())
                .requestingIP(logRequest.getRequestingIP())
                .description(logRequest.getDescription())
                .type(ELogType.INFO)
                .requestingUser(currentPrincipalName)
                .build();
        GenericLog savedLog = logRepository.save(genericLog);
        return new LogResponse(savedLog);
    }

    public LogResponse createWarnLog(LogRequest logRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        GenericLog genericLog = GenericLog.builder()
                .attemptDate(ZonedDateTime.now())
                .requestingIP(logRequest.getRequestingIP())
                .description(logRequest.getDescription())
                .type(ELogType.WARN)
                .requestingUser(currentPrincipalName)
                .build();
        GenericLog savedLog = logRepository.save(genericLog);
        return new LogResponse(savedLog);
    }

    public LogResponse createErrorLog(LogRequest logRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        GenericLog genericLog = GenericLog.builder()
                .attemptDate(ZonedDateTime.now())
                .requestingIP(logRequest.getRequestingIP())
                .description(logRequest.getDescription())
                .type(ELogType.ERROR)
                .requestingUser(currentPrincipalName)
                .build();
        GenericLog savedLog = logRepository.save(genericLog);
        return new LogResponse(savedLog);
    }

    public LogResponse createDebugLog(LogRequest logRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        GenericLog genericLog = GenericLog.builder()
                .attemptDate(ZonedDateTime.now())
                .requestingIP(logRequest.getRequestingIP())
                .description(logRequest.getDescription())
                .type(ELogType.DEBUG)
                .requestingUser(currentPrincipalName)
                .build();
        GenericLog savedLog = logRepository.save(genericLog);
        return new LogResponse(savedLog);
    }

    public LogResponse createTraceLog(LogRequest logRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        GenericLog genericLog = GenericLog.builder()
                .attemptDate(ZonedDateTime.now())
                .requestingIP(logRequest.getRequestingIP())
                .description(logRequest.getDescription())
                .type(ELogType.TRACE)
                .requestingUser(currentPrincipalName)
                .build();
        GenericLog savedLog = logRepository.save(genericLog);
        return new LogResponse(savedLog);
    }
}
