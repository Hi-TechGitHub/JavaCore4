package org.example;


public class WrongLoginException extends Exception {
    public WrongLoginException() throws WrongLoginException{
        throw new WrongLoginException("Ошибка с логином");
    }
    public WrongLoginException(String message) {
        super(message);
    }
}