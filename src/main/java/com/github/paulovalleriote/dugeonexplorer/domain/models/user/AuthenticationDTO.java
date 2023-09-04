package com.github.paulovalleriote.dugeonexplorer.domain.models.user;

import lombok.Data;

@Data
public class AuthenticationDTO {
  private String login;
  private String password;
}
