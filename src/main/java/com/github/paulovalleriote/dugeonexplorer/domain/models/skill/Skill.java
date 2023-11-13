package com.github.paulovalleriote.dugeonexplorer.domain.models.skill;

import java.io.Serializable;

import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.Sheet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "skills", indexes = @Index(columnList = "sheet_id"))
@EqualsAndHashCode(of = "id")
public class Skill implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;

  private String description;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "sheet_id")
  private Sheet sheet;
}
