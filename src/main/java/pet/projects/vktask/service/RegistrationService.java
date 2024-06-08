package pet.projects.vktask.service;

import pet.projects.vktask.dto.Client;
import pet.projects.vktask.tool.exception.ClientAlreadyRegisteredException;

public interface RegistrationService {

    void registerClient(Client client) throws ClientAlreadyRegisteredException;

}
