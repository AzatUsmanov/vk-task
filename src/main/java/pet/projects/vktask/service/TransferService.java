package pet.projects.vktask.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransferService<T> {

    ResponseEntity<T> transferPostRequest(T body);

    ResponseEntity<T> transferPutRequest(T body, Integer id);

    ResponseEntity transferDeleteByIdRequest(Integer id);

    ResponseEntity<T> transferGetByIdRequest(Integer id);

    ResponseEntity<List<T>> transferGetAllRequest();

}
