package pet.projects.vktask.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Component;

import pet.projects.vktask.service.AuditService;

import java.io.IOException;

@Component
@AllArgsConstructor
public class AuditAccessDeniedHandler extends AccessDeniedHandlerImpl {

    private final AuditService auditService;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        final var hasAccess = false;
        final var auditAction = auditService.createAudit(request, hasAccess);

        auditService.saveAudit(auditAction);
        super.handle(request, response, accessDeniedException);
    }

}
