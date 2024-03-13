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

import pet.projects.vktask.dto.Post;
import pet.projects.vktask.service.PostTransferService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/posts")
public class PostTransferController {

    private final PostTransferService postTransferService;

    @PostMapping
    public ResponseEntity<Post> transferPostRequest(@RequestBody Post body) {
        final var response = postTransferService.transferPostRequest(body);
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> transferPutRequest(@RequestBody Post body, @PathVariable Integer id) {
        final var response = postTransferService.transferPutRequest(body, id);
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity transferDeleteByIdRequest(@PathVariable Integer id) {
        final var response = postTransferService.transferDeleteByIdRequest(id);
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> transferGetByIdRequest(@PathVariable Integer id) {
        final var response = postTransferService.transferGetByIdRequest(id);
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping
    public ResponseEntity<List<Post>> transferGetAllRequest() {
        final var response = postTransferService.transferGetAllRequest();
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

}

