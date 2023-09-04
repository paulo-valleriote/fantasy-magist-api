package com.github.paulovalleriote.dugeonexplorer.domain.models.sheet;

import lombok.Data;

@Data
public class ProficiencyModifier {
  private int proficiency;

  public ProficiencyModifier() {
    this.proficiency = this.getProficiency(1);
  }

  public ProficiencyModifier(int level) {
    this.proficiency = this.getProficiency(level);
  }

  private int getProficiency(int level) {
    if (level > 4) {
      return 3;
    } else if (level > 8) {
      return 4;
    } else if (level > 12) {
      return 5;
    } else if (level > 16) {
      return 6;
    }

    return 2;
  }
}
