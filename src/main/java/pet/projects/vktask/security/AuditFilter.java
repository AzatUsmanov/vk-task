package pet.projects.vktask.security;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import pet.projects.vktask.service.AuditService;

import java.io.IOException;

@Primary
@Component
@AllArgsConstructor
public class AuditFilter implements Filter {

    private final AuditService auditService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final var httpRequest = (HttpServletRequest) request;
        final var hasAccess = true;
        final var auditAction = auditService.createAudit(httpRequest, hasAccess);

        auditService.saveAudit(auditAction);
        chain.doFilter(request, response);
    }
}
