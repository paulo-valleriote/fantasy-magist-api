package com.github.paulovalleriote.dugeonexplorer.domain.models.item;

import java.io.Serializable;

import com.github.paulovalleriote.dugeonexplorer.domain.models.bag.Bag;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "dices")
@EqualsAndHashCode(of = "id")
public class Item implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = true)
  private String description;

  @Column(nullable = false)
  private Double weight;

  @Column(nullable = false)
  private Double value;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "bag_id")
  private Bag bag;

  public Item(String name, Double weight, Double value) {
    this.name = name;
    this.weight = weight;
    this.value = value;
  }

  public Item(String name, String description, Double weight, Double value) {
    this.name = name;
    this.description = description;
    this.weight = weight;
    this.value = value;
  }
}
