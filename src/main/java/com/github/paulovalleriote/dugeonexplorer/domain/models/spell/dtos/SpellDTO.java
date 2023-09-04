package com.github.paulovalleriote.dugeonexplorer.domain.models.spell.dtos;

import com.github.paulovalleriote.dugeonexplorer.domain.models.spell.SpellSchoolEnum;

import lombok.Data;

@Data
public class SpellDTO {
  private long level;
  private String description;
  private SpellSchoolEnum magicSchool;
}
