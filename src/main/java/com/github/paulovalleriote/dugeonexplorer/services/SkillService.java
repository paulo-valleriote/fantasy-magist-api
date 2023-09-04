package com.github.paulovalleriote.dugeonexplorer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.Sheet;
import com.github.paulovalleriote.dugeonexplorer.domain.models.skill.Skill;
import com.github.paulovalleriote.dugeonexplorer.domain.models.skill.dtos.SkillDTO;
import com.github.paulovalleriote.dugeonexplorer.mapper.Mapper;
import com.github.paulovalleriote.dugeonexplorer.repositories.SkillRepository;

@Service
public class SkillService {
  @Autowired
  private SkillRepository repository;

  public SkillDTO create(SkillDTO spell, Sheet sheet) {
    Skill newSkill = Mapper.parseObject(spell, Skill.class);
    newSkill.setSheet(sheet);

    return Mapper.parseObject(repository.save(newSkill), SkillDTO.class);
  }
}
