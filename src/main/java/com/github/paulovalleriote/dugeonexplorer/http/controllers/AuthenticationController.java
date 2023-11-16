package com.github.paulovalleriote.dugeonexplorer.http.controllers;

import java.security.InvalidParameterException;

import com.github.paulovalleriote.dugeonexplorer.domain.models.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.paulovalleriote.dugeonexplorer.repositories.UserRepository;
import com.github.paulovalleriote.dugeonexplorer.services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository repository;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
    try {
      var usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
      var auth = this.authenticationManager.authenticate(usernamePassword);

      LoginResponseDTO response = tokenService.generateToken((User) auth.getPrincipal());

      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.set("Token", response.getToken());
      responseHeaders.set("ExpiresAt", response.getExpiresAt());

      return ResponseEntity
          .noContent()
          .headers(responseHeaders)
          .build();
    } catch (Exception e) {
      throw new InvalidParameterException("Login failed");
    }
  }

  @PostMapping("/register")
  public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data) {
    if (this.repository.findByLogin(data.getLogin()) != null)
      return ResponseEntity.badRequest().build();

    String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());

    UserRole role = data.getRole() != null ? data.getRole() : UserRole.PLAYER;
    User newUser = new User(data.getLogin(), encryptedPassword, role);

    this.repository.save(newUser);

    return ResponseEntity.ok().build();
  }

}
