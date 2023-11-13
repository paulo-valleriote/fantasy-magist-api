package com.github.paulovalleriote.dugeonexplorer.domain.models.sheet;

import java.io.Serializable;
import java.util.List;

import com.github.paulovalleriote.dugeonexplorer.domain.models.bag.Bag;
import com.github.paulovalleriote.dugeonexplorer.domain.models.skill.Skill;
import com.github.paulovalleriote.dugeonexplorer.domain.models.spell.Spell;
import com.github.paulovalleriote.dugeonexplorer.domain.models.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "sheets", indexes = @Index(columnList = "user_id"))
@EqualsAndHashCode(of = "id")
public class Sheet implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private SpecieEnum specie;

  @Column(name = "character_class")
  private ClassEnum characterClass;

  @Column(name = "armor_class")
  private int armorClass;

  @Column
  private int proficiency;

  @Column(nullable = false)
  private int level;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "sheet", cascade = CascadeType.ALL)
  private List<Skill> skill;

  @OneToMany(mappedBy = "sheet", cascade = CascadeType.ALL)
  private List<Spell> spell;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "bag_id")
  private Bag bag;

  public Sheet() {
    this.name = "New Sheet";
    this.specie = SpecieEnum.HUMAN;
    this.characterClass = ClassEnum.FIGHTER;
    this.level = 1;
    this.armorClass = 10;

    ProficiencyModifier proficiencyModifier = new ProficiencyModifier();
    this.proficiency = proficiencyModifier.getProficiency();
  }

  public Sheet(String name, SpecieEnum specie, ClassEnum characterClass, int armorClass, int level) {
    this.name = name;
    this.specie = specie;
    this.level = level;
    this.characterClass = characterClass;
    this.armorClass = armorClass + this.proficiency;

    ProficiencyModifier proficiencyModifier = new ProficiencyModifier(level);
    this.proficiency = proficiencyModifier.getProficiency();
  }
}
