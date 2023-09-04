package com.github.paulovalleriote.dugeonexplorer.domain.models.dice;

import javax.naming.directory.InvalidAttributeValueException;

public class Dice {
  private int choosed_dice;

  public Dice(DiceEnum dice) throws InvalidAttributeValueException {
    handleDiceValue(dice, null);
  }

  public Dice(String dice) throws InvalidAttributeValueException {
    handleDiceValue(null, dice);
  }

  public int getDice() {
    return this.choosed_dice;
  }

  public void setDice(DiceEnum dice, String diceValue) throws InvalidAttributeValueException {
    handleDiceValue(dice, diceValue);
  }

  private void handleDiceValue(DiceEnum dice, String diceValue) throws InvalidAttributeValueException {
    if (dice != null) {
      switch (dice) {
        case D100:
          this.choosed_dice = 100;
          break;
        case D20:
          this.choosed_dice = 20;
          break;
        case D12:
          this.choosed_dice = 12;
          break;
        case D10:
          this.choosed_dice = 10;
          break;
        case D8:
          this.choosed_dice = 8;
          break;
        case D6:
          this.choosed_dice = 6;
          break;
        case D4:
          this.choosed_dice = 4;
          break;
      }
    }

    if (dice == null && !diceValue.isEmpty() || diceValue != null) {
      this.choosed_dice = Integer.parseInt(diceValue);
    }

    if (this.choosed_dice < 1 || diceValue == null || diceValue.isEmpty() || diceValue.isBlank()) {
      throw new InvalidAttributeValueException("Dice value can't be defined");
    }
  }
}
