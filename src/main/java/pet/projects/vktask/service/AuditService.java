package pet.projects.vktask.service;

import jakarta.servlet.http.HttpServletRequest;

import pet.projects.vktask.dto.AuditAction;

public interface AuditService {

    void saveAudit(AuditAction auditAction);

    AuditAction createAudit(HttpServletRequest request, Boolean hasAccess);

}
