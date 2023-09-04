package com.github.paulovalleriote.dugeonexplorer.unit_tests.models_testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.paulovalleriote.dugeonexplorer.domain.models.bag.Bag;

public class BagTest {
  @Test
  public void itShouldCreateAnNewBagWithoutItems() {
    Bag newBag = new Bag();

    Assertions.assertEquals(0.0, newBag.getWeight());
  }
}
