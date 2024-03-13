package pet.projects.vktask.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pet.projects.vktask.dto.Post;
import pet.projects.vktask.rest.api.PostClient;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PostTransferService implements TransferService<Post> {

    private final PostClient postClient;

    @Override
    public ResponseEntity<Post> transferPostRequest(Post body) {
        final var response = postClient.createPost(body);
        log.info("Post request with body :" + body.toString()+ " successfully transferred");
        return response;
    }

    @Override
    @CachePut(value = "posts", key = "#id")
    public ResponseEntity<Post> transferPutRequest(Post body, Integer id) {
        final var response = postClient.putPost(body, id);
        log.info("Put request with body :" + body.toString() + " and id = " + id.toString() + "successfully transferred");
        return response;
    }

    @Override
    @CacheEvict(value = "posts", key = "#id")
    public ResponseEntity transferDeleteByIdRequest(Integer id) {
        final var response = postClient.deletePostById(id);
        log.info("Delete request with id = " + id.toString() + "successfully transferred");
        return response;
    }

    @Override
    @Cacheable(value = "posts", key = "#id")
    public ResponseEntity<Post> transferGetByIdRequest(Integer id) {
        final var response = postClient.findPostById(id);
        log.info("Get request with id = " + id.toString() + "successfully transferred");
        return response;
    }

    @Override
    public ResponseEntity<List<Post>> transferGetAllRequest() {
        final var response = postClient.findAllPosts();
        log.info("Get all request successfully transferred");
        return response;
    }

}
