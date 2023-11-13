package com.github.paulovalleriote.dugeonexplorer.domain.models.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDTO {
  private String token;
  private String expiresAt;
}
