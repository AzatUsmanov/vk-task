package pet.projects.vktask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.projects.vktask.dto.AuditAction;

public interface AuditRepository extends JpaRepository<AuditAction, Integer> {
}
