package com.github.paulovalleriote.dugeonexplorer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.Sheet;
import com.github.paulovalleriote.dugeonexplorer.domain.models.spell.Spell;
import com.github.paulovalleriote.dugeonexplorer.domain.models.spell.dtos.SpellDTO;
import com.github.paulovalleriote.dugeonexplorer.mapper.Mapper;
import com.github.paulovalleriote.dugeonexplorer.repositories.SpellRepository;

@Service
public class SpellService {
  @Autowired
  private SpellRepository repository;

  public SpellDTO create(SpellDTO spell, Sheet sheet) {
    Spell newSpell = Mapper.parseObject(spell, Spell.class);
    newSpell.setSheet(sheet);

    return Mapper.parseObject(repository.save(newSpell), SpellDTO.class);
  }
}
