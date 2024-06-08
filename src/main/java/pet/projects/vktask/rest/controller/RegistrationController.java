package pet.projects.vktask.rest.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pet.projects.vktask.dto.Client;
import pet.projects.vktask.service.RegistrationService;
import pet.projects.vktask.tool.exception.ClientAlreadyRegisteredException;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/registration")
    public void registerClient(@RequestBody Client client) throws ClientAlreadyRegisteredException {
        registrationService.registerClient(client);
    }

}
