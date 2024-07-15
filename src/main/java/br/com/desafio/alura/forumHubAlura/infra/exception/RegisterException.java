package br.com.desafio.alura.forumHubAlura.infra.exception;

public class RegisterException extends RuntimeException {
    public RegisterException(String message) {
        super(message);
    }
}
