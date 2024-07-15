package br.com.desafio.alura.forumHubAlura.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosRegistroTopico(@NotBlank
                                  String titulo,
                                  @NotBlank
                                  String mensagem,
                                  @NotBlank
                                  String curso) {
}
