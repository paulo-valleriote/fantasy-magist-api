package com.github.paulovalleriote.dugeonexplorer.domain.models.user;

public enum UserRole {
  PLAYER("player"),
  ADMIN("admin");

  private String role;

  UserRole(String role) {
    this.role = role;
  }

  public String getRole() {
    return role;
  }
}
