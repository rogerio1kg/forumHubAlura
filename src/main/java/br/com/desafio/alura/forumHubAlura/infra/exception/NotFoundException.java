package br.com.desafio.alura.forumHubAlura.infra.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
