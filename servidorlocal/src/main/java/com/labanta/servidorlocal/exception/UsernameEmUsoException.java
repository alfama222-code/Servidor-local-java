package com.labanta.servidorlocal.exception;

public class UsernameEmUsoException extends RuntimeException {
    public UsernameEmUsoException(String message) {
        super("Este username já está em uso, por favor escolha outro.");
    }
}
