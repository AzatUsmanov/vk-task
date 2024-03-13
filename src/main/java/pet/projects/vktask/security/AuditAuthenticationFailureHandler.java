package pet.projects.vktask.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import pet.projects.vktask.service.AuditService;

import java.io.IOException;

@Component
@AllArgsConstructor
public class AuditAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final AuditService auditService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        final var hasAccess = false;
        final var auditAction = auditService.createAudit(request, hasAccess);

        auditService.saveAudit(auditAction);
        super.onAuthenticationFailure(request, response, exception);
    }

}
