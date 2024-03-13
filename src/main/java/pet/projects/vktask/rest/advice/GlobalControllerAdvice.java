package pet.projects.vktask.rest.advice;

import feign.FeignException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pet.projects.vktask.dto.ErrorDetails;

@Slf4j
@ControllerAdvice
public class GlobalControllerAdvice {


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDetails> DataIntegrityViolationExceptionHandle(
            DataIntegrityViolationException exception
    ) {
        log.error("Incorrect input");
        final var errorDetails = new ErrorDetails("Incorrect input");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorDetails);
    }


    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorDetails> FeignExceptionHandle(
            FeignException exception
    ) {
        log.error("Incorrect request to jsonplaceholder");
        final var errorDetails = new ErrorDetails("Incorrect request to jsonplaceholder");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorDetails);
    }

}
