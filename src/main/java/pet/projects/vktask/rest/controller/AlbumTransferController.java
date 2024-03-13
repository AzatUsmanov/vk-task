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

import pet.projects.vktask.dto.Album;
import pet.projects.vktask.service.TransferService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/albums")
public class AlbumTransferController {

    private final TransferService<Album> albumTransferService;

    @PostMapping
    public ResponseEntity<Album> transferPostRequest(@RequestBody Album body) {
        final var response = albumTransferService.transferPostRequest(body);
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> transferPutRequest(@RequestBody Album body, @PathVariable Integer id) {
        final var response = albumTransferService.transferPutRequest(body, id);
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity transferDeleteByIdRequest(@PathVariable Integer id) {
        final var response =albumTransferService.transferDeleteByIdRequest(id);
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> transferGetByIdRequest(@PathVariable Integer id) {
        final var response = albumTransferService.transferGetByIdRequest(id);
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping
    public ResponseEntity<List<Album>> transferGetAllRequest() {
        final var response = albumTransferService.transferGetAllRequest();
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

}

