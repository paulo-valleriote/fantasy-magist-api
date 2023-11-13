package com.github.paulovalleriote.dugeonexplorer.domain.models.user;

import lombok.Data;

@Data
public class RegisterDTO {
  private String username;
  private String login;
  private String password;
  private UserRole role;
}
