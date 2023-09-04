package com.github.paulovalleriote.dugeonexplorer.domain.models.sheet;

public enum ClassEnum {
  BARBARIAN("barbarian"),
  BARD("bard"),
  CLERIC("cleric"),
  DRUID("druid"),
  FIGHTER("fighter"),
  MONK("monk"),
  PALADIN("paladin"),
  RANGER("ranger"),
  ROGUE("rogue"),
  SORCERER("sorcerer"),
  WARLOCK("warlock"),
  WIZARD("wizard"),
  ARTIFICER("artificer"),
  BLOOD_HUNTER("blood hunter");

  private String className;

  ClassEnum(String characterClass) {
    this.className = characterClass;
  }

  public String getClassName() {
    return className;
  }
}
