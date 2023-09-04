package com.github.paulovalleriote.dugeonexplorer.unit_tests.models_testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.paulovalleriote.dugeonexplorer.domain.models.dice.Dice;
import com.github.paulovalleriote.dugeonexplorer.domain.models.dice.DiceEnum;

public class DiceTest {
  @Test
  public void itShouldCreateAnNewDice() {
    Dice testDice;

    try {
      testDice = new Dice(DiceEnum.D100);
    } catch (javax.naming.directory.InvalidAttributeValueException e) {
      return;
    }

    Assertions.assertTrue(testDice.getDice() >= 1);
  }

  @Test
  public void itShouldCreateAnNewDiceWithCustomizedValue() {
    String testValue = "24";
    Dice testDice;

    try {
      testDice = new Dice(testValue);
    } catch (javax.naming.directory.InvalidAttributeValueException e) {
      return;
    }

    Assertions.assertEquals(true, testDice.getDice() == Integer.parseInt(testValue));
  }

  @Test
  public void itShouldNotCreateAnNewDice() {
    Boolean hasCatched = false;

    try {
      new Dice("");
    } catch (javax.naming.directory.InvalidAttributeValueException e) {
      hasCatched = true;
    }

    Assertions.assertTrue(hasCatched);
  }
}
