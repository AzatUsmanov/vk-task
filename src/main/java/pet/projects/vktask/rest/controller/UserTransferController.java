package pet.projects.vktask.rest.controller;


import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pet.projects.vktask.dto.User;
import pet.projects.vktask.service.TransferService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserTransferController {

    private final TransferService<User> userTransferService;

    @PostMapping
    public ResponseEntity<User> transferPostRequest(@RequestBody User body) {
        final var response = userTransferService.transferPostRequest(body);
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> transferPutRequest(@RequestBody User body, @PathVariable Integer id) {
        final var response = userTransferService.transferPutRequest(body, id);
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity transferDeleteByIdRequest(@PathVariable Integer id) {
        final var response = userTransferService.transferDeleteByIdRequest(id);
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> transferGetByIdRequest(@PathVariable Integer id) {
        final var response = userTransferService.transferGetByIdRequest(id);
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping
    public ResponseEntity<List<User>> transferGetAllRequest() {
        final var response = userTransferService.transferGetAllRequest();
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

}

