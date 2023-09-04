package com.github.paulovalleriote.dugeonexplorer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.paulovalleriote.dugeonexplorer.domain.models.spell.Spell;

public interface SpellRepository extends JpaRepository<Spell, String> {

}
