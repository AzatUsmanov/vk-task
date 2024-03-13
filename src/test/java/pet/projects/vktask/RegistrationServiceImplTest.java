package pet.projects.vktask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.security.crypto.password.PasswordEncoder;

import pet.projects.vktask.dto.Client;
import pet.projects.vktask.repositories.ClientRepository;
import pet.projects.vktask.service.RegistrationServiceImpl;
import pet.projects.vktask.tool.exception.ClientAlreadyRegisteredException;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegistrationServiceImplTest  {

    @Mock
    private ClientRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private RegistrationServiceImpl service;

    @Test
    public void registerNoExistentClient() {
        final var client = buildUser();
        when(repository.existsByUsername(client.getUsername()))
                .thenReturn(false);
        when(passwordEncoder.encode(client
                .getPassword()))
                .thenReturn("password");

        service.registerClient(client);

        verify(repository, times(1))
                .save(client);
    }

    @Test
    public void registerExistentClient() {
        final var user = buildUser();
        when(repository.existsByUsername(user.getUsername()))
                .thenReturn(true);
        when(passwordEncoder.encode(user.getPassword()))
                .thenReturn("password");

        assertThatThrownBy(() -> service.registerClient(user))
                .isInstanceOf(ClientAlreadyRegisteredException.class);
    }

    private Client buildUser() {
        return Client.builder()
                .id(Integer.MAX_VALUE)
                .username("username")
                .password("password")
                .roles(new ArrayList<>() {})
                .build();
    }

}
