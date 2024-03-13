package pet.projects.vktask.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    private Integer id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<Client> Clients;

}
