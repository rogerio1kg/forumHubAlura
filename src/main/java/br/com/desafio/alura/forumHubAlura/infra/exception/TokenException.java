package br.com.desafio.alura.forumHubAlura.infra.exception;

public class TokenException extends RuntimeException {
    public TokenException(String mensagem) {
        super(mensagem);
    }
}
