package com.github.paulovalleriote.dugeonexplorer.unit_tests.models_testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.paulovalleriote.dugeonexplorer.domain.models.item.Item;

public class ItemTest {
  @Test
  public void itShouldCreateAnNewItemWithoutDescription() {
    String name = "testItem";
    Double weight = 1.0;
    Double value = 10.0;

    Item newItem = new Item(name, weight, value);

    Assertions.assertEquals(newItem.getName(), name);
    Assertions.assertEquals(newItem.getValue(), value);
    Assertions.assertEquals(null, newItem.getDescription());
  }

  @Test
  public void itShouldCreateAnNewItemWithDescription() {
    String name = "testItem";
    String description = "Test description for the test item, this is a test";
    Double weight = 1.0;
    Double value = 10.0;

    Item newItem = new Item(name, description, weight, value);

    Assertions.assertEquals(newItem.getName(), name);
    Assertions.assertEquals(newItem.getValue(), value);
    Assertions.assertEquals(newItem.getDescription(), description);
  }
}
