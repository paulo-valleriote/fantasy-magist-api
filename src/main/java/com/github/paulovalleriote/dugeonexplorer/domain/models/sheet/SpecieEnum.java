package com.github.paulovalleriote.dugeonexplorer.domain.models.sheet;

public enum SpecieEnum {
  DRAGONBORN("dragonborn"),
  DWARF("dwarf"),
  ELF("elf"),
  GNOME("gnome"),
  HALF_ELF("half elf"),
  HALFLING("halfling"),
  HALF_ORC("half orc"),
  HUMAN("human"),
  TIEFLING("tiefling");

  private String specie;

  SpecieEnum(String characterClass) {
    this.specie = characterClass.toUpperCase();
  }

  public String getSpecie() {
    return specie;
  }
}
