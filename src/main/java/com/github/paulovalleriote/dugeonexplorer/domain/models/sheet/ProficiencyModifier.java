package com.github.paulovalleriote.dugeonexplorer.domain.models.sheet;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProficiencyModifier implements Serializable {
  private static final long serialVersionUID = 1L;

  private int proficiency;

  ProficiencyModifier() {
    this.proficiency = this.getProficiency(1);
  }

  ProficiencyModifier(int level) {
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
    } else {
      return 2;
    }
  }
}
