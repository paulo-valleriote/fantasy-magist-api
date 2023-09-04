package com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SheetDTO {
  private String name;

  private String specie;

  private String characterClass;

  private int level;
}
