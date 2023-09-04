package com.github.paulovalleriote.dugeonexplorer.domain.models.attributes;

import java.io.Serializable;

import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.Sheet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@Entity
@Table(name = "attributes")
@EqualsAndHashCode(of = "id")
public class Attributes implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private long strenght;

  @Column(nullable = false)
  private long dexterity;

  @Column(nullable = false)
  private long constitution;

  @Column(nullable = false)
  private long intelligence;

  @Column(nullable = false)
  private long wisdom;

  @Column(nullable = false)
  private long charisma;

  @OneToOne
  @JoinColumn(name = "sheet_id")
  private Sheet sheet;

  public Attributes() {
    this.strenght = 10;
    this.dexterity = 10;
    this.constitution = 10;
    this.intelligence = 10;
    this.wisdom = 10;
    this.charisma = 10;
  }
}
