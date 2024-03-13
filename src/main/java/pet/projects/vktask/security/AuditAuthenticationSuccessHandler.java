package pet.projects.vktask.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import pet.projects.vktask.service.AuditService;

import java.io.IOException;
@Component
@AllArgsConstructor
public class AuditAuthenticationSuccessHandler extends  SavedRequestAwareAuthenticationSuccessHandler  {

    private final AuditService auditService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication)
            throws IOException, ServletException {
        final var hasAccess = true;
        final var auditAction = auditService.createAudit(request, hasAccess);

        auditService.saveAudit(auditAction);
        super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        final var hasAccess = true;
        final var auditAction = auditService.createAudit(request, hasAccess);

        auditService.saveAudit(auditAction);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
