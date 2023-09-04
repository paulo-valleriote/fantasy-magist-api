package com.github.paulovalleriote.dugeonexplorer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.paulovalleriote.dugeonexplorer.domain.models.skill.Skill;

public interface SkillRepository extends JpaRepository<Skill, String> {

}
