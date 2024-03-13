package pet.projects.vktask.security;


import lombok.AllArgsConstructor;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pet.projects.vktask.dto.Client;
import pet.projects.vktask.repositories.ClientRepository;

import java.util.ArrayList;



@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var client = clientRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return convertCLientToUserDetails(client);
    }

    private UserDetails convertCLientToUserDetails(Client client) {
        final var list = new ArrayList<SimpleGrantedAuthority>();
        final var roles = client.getRoles();

        roles.forEach((x) -> {
            list.add(new SimpleGrantedAuthority(x.getName()));
        });

        return new org.springframework.security.core.userdetails.User(
                client.getUsername(),
                client.getPassword(),
                list
        );
    }

}