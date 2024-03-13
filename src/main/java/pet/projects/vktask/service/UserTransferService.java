package pet.projects.vktask.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pet.projects.vktask.dto.User;
import pet.projects.vktask.rest.api.UserClient;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserTransferService implements TransferService<User> {

    private final UserClient userClient;

    @Override
    public ResponseEntity<User> transferPostRequest(User body) {
        final var response = userClient.createUser(body);
        log.info("Post request with body :" + body.toString()+ " successfully transferred");
        return response;
    }

    @Override
    @CachePut(value = "users", key = "#id")
    public ResponseEntity<User> transferPutRequest(User body, Integer id) {
        final var response =  userClient.putUser(body, id);
        log.info("Put request with body :" + body.toString() + " and id = " + id.toString() + "successfully transferred");
        return response;
    }

    @Override
    @CacheEvict(value = "users", key ="#id")
    public ResponseEntity transferDeleteByIdRequest(Integer id) {
        final var response = userClient.deleteUserById(id);
        log.info("Delete request with id = " + id.toString() + "successfully transferred");
        return response;

    }

    @Override
    @Cacheable(value = "users", key ="#id")
    public ResponseEntity<User> transferGetByIdRequest(Integer id) {
        final var response = userClient.findUserById(id);
        log.info("Get request with id = " + id.toString() + "successfully transferred");
        return response;
    }

    @Override
    public ResponseEntity<List<User>> transferGetAllRequest() {
        final var response = userClient.findAllUsers();
        log.info("Get all request successfully transferred");
        return response;
    }

}
