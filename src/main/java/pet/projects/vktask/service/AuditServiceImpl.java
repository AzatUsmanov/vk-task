package pet.projects.vktask.service;

import jakarta.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import pet.projects.vktask.dto.AuditAction;
import pet.projects.vktask.repositories.AuditRepository;

import java.sql.Timestamp;

@Service
@AllArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;


    @Override
    public AuditAction createAudit(HttpServletRequest request, Boolean hasAccess) {
        return AuditAction.builder()
                .uri(request.getRequestURI())
                .DateAction(new Timestamp(System.currentTimeMillis()))
                .httpMethod(request.getMethod())
                .username(request.getRemoteUser())
                .hasAccess(hasAccess)
                .build();
    }

    @Override
    public void saveAudit(AuditAction auditAction) {
        auditRepository.save(auditAction);
    }

}
