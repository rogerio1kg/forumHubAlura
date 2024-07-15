package br.com.desafio.alura.forumHubAlura.domain.repository;

import br.com.desafio.alura.forumHubAlura.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);
}
