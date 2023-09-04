package com.github.paulovalleriote.dugeonexplorer.domain.models.bag;

import java.io.Serializable;

import com.github.paulovalleriote.dugeonexplorer.domain.models.sheet.Sheet;

import jakarta.persistence.CascadeType;
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
@Entity
@AllArgsConstructor
@Table(name = "bags")
@EqualsAndHashCode(of = "id")
public class Bag implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private Double weight;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "sheet_id")
  private Sheet sheet;

  public Bag() {
    this.weight = 0.0;
  }
}
