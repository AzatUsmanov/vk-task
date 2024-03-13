package pet.projects.vktask.rest.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pet.projects.vktask.dto.Post;

import java.util.List;

@FeignClient(name = "post",
        url = "${client.post.url}")
public interface PostClient {

    @PostMapping
    ResponseEntity<Post> createPost(@RequestBody Post post);

    @PutMapping("/{id}")
    ResponseEntity<Post> putPost(@RequestBody Post post, @PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity deletePostById(@PathVariable("id") Integer id);

    @GetMapping(value = "/{id}", produces = "application/json")
    ResponseEntity<Post> findPostById(@PathVariable("id") Integer id);

    @GetMapping
    ResponseEntity<List<Post>> findAllPosts();

}
