package pet.projects.vktask.rest.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pet.projects.vktask.dto.User;

import java.util.List;

@FeignClient(name = "user",
        url = "${client.user.url}")
public interface UserClient {

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user);

    @PutMapping("/{id}")
    ResponseEntity<User> putUser(@RequestBody User user, @PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity deleteUserById(@PathVariable("id") Integer id);

    @GetMapping("/{id}")
    ResponseEntity<User> findUserById(@PathVariable("id") Integer id);

    @GetMapping
    ResponseEntity<List<User>> findAllUsers();

}
