package com.github.paulovalleriote.dugeonexplorer.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.github.paulovalleriote.dugeonexplorer.domain.models.user.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.github.paulovalleriote.dugeonexplorer.domain.models.user.User;

@Service
public class TokenService {
  @Value("${api.security.token.secret}")
  private String secret;

  public LoginResponseDTO generateToken(User user) {

    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      Instant expiration = this.generateExpirationDate();

      String token = JWT.create()
          .withIssuer("auth-api")
          .withSubject(user.getId() + ',' + user.getLogin())
          .withExpiresAt(expiration)
          .sign(algorithm);

      return LoginResponseDTO.builder()
          .token(token)
          .expiresAt(expiration.toString())
          .build();
    } catch (JWTCreationException exception) {
      throw new RuntimeException("Error while generating token");
    }
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      return JWT.require(algorithm)
          .withIssuer("auth-api")
          .build()
          .verify(token)
          .getSubject();
    } catch (JWTVerificationException exception) {
      return "";
    }
  }

  private Instant generateExpirationDate() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }
}
