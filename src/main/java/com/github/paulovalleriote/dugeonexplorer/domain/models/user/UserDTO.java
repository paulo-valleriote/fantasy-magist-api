package com.github.paulovalleriote.dugeonexplorer.domain.models.user;

import lombok.Data;

@Data
public class UserDTO {
  private String id;
  private String username;
  private String role;
}
