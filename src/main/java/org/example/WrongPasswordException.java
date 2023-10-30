package org.example;

public class WrongPasswordException extends Throwable {
    public WrongPasswordException() throws WrongPasswordException {
        throw new WrongPasswordException("Ошибка с паролями");
    }
    public WrongPasswordException(String message) {
        super(message);
    }
}
