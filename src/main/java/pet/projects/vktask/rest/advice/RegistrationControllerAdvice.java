package pet.projects.vktask.rest.advice;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pet.projects.vktask.dto.ErrorDetails;
import pet.projects.vktask.tool.exception.ClientAlreadyRegisteredException;

@Slf4j
@ControllerAdvice
public class RegistrationControllerAdvice {

    @ExceptionHandler(ClientAlreadyRegisteredException.class)
    public ResponseEntity<ErrorDetails> FeignExceptionHandle(
            ClientAlreadyRegisteredException exception
    ) {
        log.error("Client already registered");
        final var errorDetails = new ErrorDetails("Client already registered");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorDetails);
    }

}
