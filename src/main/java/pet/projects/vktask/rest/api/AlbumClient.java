package pet.projects.vktask.rest.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pet.projects.vktask.dto.Album;

import java.util.List;

@FeignClient(name = "album",
        url = "${client.album.url}")
public interface AlbumClient {

    @PostMapping
    ResponseEntity<Album> createAlbum(@RequestBody Album album);

    @PutMapping("/{id}")
    ResponseEntity<Album> putAlbum(@RequestBody Album album, @PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity deleteAlbumById(@PathVariable("id") Integer id);

    @GetMapping("/{id}")
    ResponseEntity<Album> findAlbumById(@PathVariable("id") Integer id);

    @GetMapping
    ResponseEntity<List<Album>> findAllAlbums();

}

