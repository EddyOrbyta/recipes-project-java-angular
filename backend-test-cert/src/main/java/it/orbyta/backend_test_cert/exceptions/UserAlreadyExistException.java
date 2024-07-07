package it.orbyta.backend_test_cert.exceptions;

public class UserAlreadyExistException extends Throwable {

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
