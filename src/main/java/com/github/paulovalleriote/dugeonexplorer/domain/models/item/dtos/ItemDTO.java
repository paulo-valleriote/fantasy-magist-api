package com.github.paulovalleriote.dugeonexplorer.domain.models.item.dtos;

import lombok.Data;

@Data
public class ItemDTO {
  private String name;
  private String description;
  private Double weight;
  private Double value;
}
