package pet.projects.vktask.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pet.projects.vktask.dto.Client;
import pet.projects.vktask.repositories.ClientRepository;
import pet.projects.vktask.tool.exception.ClientAlreadyRegisteredException;

@Slf4j
@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final ClientRepository clientRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerClient(Client client) {
        final var password = client.getPassword();
        final var encryptedPassword = passwordEncoder.encode(password);
        final var username = client.getUsername();
        client.setPassword(encryptedPassword);

        if (clientRepository.existsByUsername(username)) {
            throw new ClientAlreadyRegisteredException("User already exists");
        }
        clientRepository.save(client);
        log.info("User "  + client.toString() + "successfully registered");
    }

}
