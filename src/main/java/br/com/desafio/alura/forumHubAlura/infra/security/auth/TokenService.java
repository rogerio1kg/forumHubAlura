package br.com.desafio.alura.forumHubAlura.infra.security.auth;

import br.com.desafio.alura.forumHubAlura.domain.usuario.Usuario;
import br.com.desafio.alura.forumHubAlura.infra.exception.TokenException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    public String gerar(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(usuario.getId().toString())
                .withExpiresAt(LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")))
                .withIssuer("API ForumHub")
                .sign(algorithm);
    }

    public Long getSubject(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        try {
            String subject = JWT.require(algorithm)
                    .withIssuer("API ForumHub")
                    .build()
                    .verify(token)
                    .getSubject();
            return Long.valueOf(subject);
        }catch (Exception e) {
            throw new TokenException("Token invalido ou expirado");
        }
    }
}