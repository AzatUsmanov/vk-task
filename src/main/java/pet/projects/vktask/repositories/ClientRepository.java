package pet.projects.vktask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.projects.vktask.dto.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findByUsername(String username);

    boolean existsByUsername(String username);

}
