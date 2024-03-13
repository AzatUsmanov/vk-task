package pet.projects.vktask.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "audit")
@Builder
public class AuditAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_action")
    private Timestamp DateAction;

    private String username;

    @Column(name = "http_method")
    private String httpMethod;

    private String uri;

    @Column(name = "has_access")
    private boolean hasAccess;

}
