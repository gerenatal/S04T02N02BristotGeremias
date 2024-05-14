package cat.itacademy.barcelonactiva.bristot.geremias.s04.t02.n02.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FruitExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FruitAlreadyExistException.class)
    public ResponseEntity<String> fruitAlreadyExistException(FruitAlreadyExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(FruitNotFoundException.class)
    public ResponseEntity<String> fruitNotFoundException(FruitNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}