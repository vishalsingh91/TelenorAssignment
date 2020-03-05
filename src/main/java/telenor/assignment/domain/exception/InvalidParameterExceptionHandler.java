package telenor.assignment.domain.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class InvalidParameterExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body("Invalid parameter: " + e.getMessage());
    }

}
