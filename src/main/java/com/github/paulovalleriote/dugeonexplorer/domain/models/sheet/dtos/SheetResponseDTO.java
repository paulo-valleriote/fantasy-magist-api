package com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.dtos;

import com.github.paulovalleriote.dugeonexplorer.domain.models.user.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SheetResponseDTO extends SheetDTO {
  private UserDTO user;

  public SheetResponseDTO(SheetDTO sheet, UserDTO user) {
    super(sheet.getName(), sheet.getSpecie(), sheet.getCharacterClass(), sheet.getArmorClass(),
        sheet.getLevel(), sheet.getProficiency());
    this.user = user;
  }
}
