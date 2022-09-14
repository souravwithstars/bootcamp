package com.tw.step8.chance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

  @Test
  void ShouldRepresentChanceOfGettingTails() throws InvalidProbability {
    Chance chance = Chance.createChance(0.5);
    Chance chance2 = Chance.createChance(0.5);

    assertTrue(chance.equals(chance2));
  }

  @Test
  void ShouldNotRepresentAChance() {
    try {
      Chance chance = Chance.createChance(.2);
    } catch (InvalidProbability e) {
      assertEquals("Probability should be between 0-1", e.getMessage());
    }
  }

  @Test
  void ShouldRepresentChanceOfNotGettingTails() throws InvalidProbability {
    Chance chance1 = Chance.createChance(0.4);
    Chance chance2 = Chance.createChance(0.6);

    assertTrue(chance2.equals(chance1.notAChance()));
  }

  @Test
  void combineChance() throws InvalidProbability {
    Chance chance1 = Chance.createChance(0.5);
    Chance chance2 = Chance.createChance(0.5);

    Chance expected = Chance.createChance(0.25);
    assertTrue(expected.equals(chance1.combineChance(chance2)));
  }
}