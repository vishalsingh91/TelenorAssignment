package telenor.assignment.domain.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TelenorBusinessRequirementNotMeetException {

    @ExceptionHandler({PathNotYetImplementedException.class})
    public ResponseEntity handleConstraintViolationException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
