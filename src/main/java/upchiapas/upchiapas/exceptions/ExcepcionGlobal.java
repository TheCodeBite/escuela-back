package upchiapas.upchiapas.exceptions;

import jakarta.validation.ConstraintViolationException;
import upchiapas.upchiapas.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcepcionGlobal {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> validadorManejoExcepcion(ValidationException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        StringBuilder errors = new StringBuilder();
        ex.getConstraintViolations().forEach(violation -> {
            errors.append(violation.getMessage()).append("; ");
        });
        return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
    }


}
