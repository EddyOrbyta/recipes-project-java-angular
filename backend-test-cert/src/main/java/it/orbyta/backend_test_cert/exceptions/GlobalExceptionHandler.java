package it.orbyta.backend_test_cert.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(RicettaNotFoundException.class)
    public ResponseEntity<String> handleRicettaNotFoundException(RicettaNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(IngredienteNotFoundException.class)
    public ResponseEntity<String> handleIngredienteNotFoundException(IngredienteNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<String> handleUserAlreadyExistException(UserAlreadyExistException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(PasswordDoesntMatchException.class)
    public ResponseEntity<String> handlePasswordDoesntMatchException(PasswordDoesntMatchException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}