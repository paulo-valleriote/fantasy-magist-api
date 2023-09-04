package com.github.paulovalleriote.dugeonexplorer.domain.models.sheet;

import java.io.Serializable;

import com.github.paulovalleriote.dugeonexplorer.domain.models.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "sheets")
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
  private ProficiencyModifier proficiency;

  @Column(nullable = false)
  private int level;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;

  public Sheet() {
    this.name = "New Sheet";
    this.specie = SpecieEnum.HUMAN;
    this.characterClass = ClassEnum.FIGHTER;
    this.level = 1;
    this.armorClass = 10;
    this.proficiency = new ProficiencyModifier();
  }

  public Sheet(String name, SpecieEnum specie, ClassEnum characterClass, int armorClass, int level) {
    this.name = name;
    this.specie = specie;
    this.level = level;
    this.characterClass = characterClass;
    this.armorClass = armorClass + this.proficiency.getProficiency();
    this.proficiency = new ProficiencyModifier(level);
  }
}
