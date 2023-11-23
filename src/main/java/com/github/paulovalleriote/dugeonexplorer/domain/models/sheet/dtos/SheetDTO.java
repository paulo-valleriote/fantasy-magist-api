package com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.dtos;

import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.ClassEnum;
import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.SpecieEnum;

import com.github.paulovalleriote.dugeonexplorer.services.SheetService;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SheetDTO {
  private String name;
  private SpecieEnum specie;
  private ClassEnum characterClass;
  private int armorClass;
  private int proficiency;
  private int level;
  public SheetDTO(String name, SpecieEnum specie, ClassEnum characterClass, int level) {
    this.name = name;
    this.specie = specie;
    this.characterClass = characterClass;
    this.level = level;
    this.armorClass = 12;
    this.proficiency = SheetService.calculateProficiency(level);
  }
}
