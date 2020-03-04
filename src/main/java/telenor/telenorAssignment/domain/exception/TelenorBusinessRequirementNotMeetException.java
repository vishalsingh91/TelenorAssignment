package telenor.telenorAssignment.domain.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class TelenorBusinessRequirementNotMeetException {

    @ExceptionHandler({PathNotYetImplementedException.class})
    public ResponseEntity handleConstraintViolationException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
