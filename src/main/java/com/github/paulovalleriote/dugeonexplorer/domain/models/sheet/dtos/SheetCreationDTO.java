package com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SheetCreationDTO {
  private SheetDTO sheet;
  private String userId;
}
