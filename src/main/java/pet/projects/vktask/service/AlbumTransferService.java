package pet.projects.vktask.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pet.projects.vktask.dto.Album;
import pet.projects.vktask.rest.api.AlbumClient;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AlbumTransferService implements TransferService<Album> {

    private final AlbumClient albumClient;

    @Override
    public ResponseEntity<Album> transferPostRequest(Album body) {
        final var response = albumClient.createAlbum(body);
        log.info("Post request with body :" + body.toString()+ " successfully transferred");
        return response;
    }

    @Override
    @CachePut(value = "albums", key = "#id")
    public ResponseEntity<Album> transferPutRequest(Album body, Integer id) {
        final var response = albumClient.putAlbum(body, id);
        log.info("Put request with body :" + body.toString() + " and id = " + id.toString() + "successfully transferred");
        return response;
    }

    @Override
    @CacheEvict(value ="albums", key = "#id")
    public ResponseEntity transferDeleteByIdRequest(Integer id) {
        final var response = albumClient.deleteAlbumById(id);
        log.info("Delete request with id = " + id.toString() + "successfully transferred");
        return response;
    }

    @Override
    @Cacheable(value ="albums", key = "#id")
    public ResponseEntity<Album> transferGetByIdRequest(Integer id) {
        final var response = albumClient.findAlbumById(id);
        log.info("Get request with id = " + id.toString() + "successfully transferred");
        return response;
    }

    @Override
    public ResponseEntity<List<Album>> transferGetAllRequest() {
        final var response = albumClient.findAllAlbums();
        log.info("Get all request successfully transferred");
        return response;
    }

}
