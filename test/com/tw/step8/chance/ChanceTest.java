package com.tw.step8.chance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

  @Test
  void ShouldRepresentChanceOfGettingTails() throws InvalidProbability {
    Chance chance = Chance.createChance(0.12);

    assertEquals(0.12, chance.getProbability());
  }

  @Test
  void ShouldNotRepresentAChance() {
    try {
      Chance chance = Chance.createChance(2);
    } catch (InvalidProbability e) {
      assertEquals("Probability should be between 0-1", e.getMessage());
    }
  }

  @Test
  void ShouldRepresentChanceOfNotGettingTails() throws InvalidProbability {
    Chance chance1 = Chance.createChance(0.12);
    Chance chance2 = Chance.createChance(0.88);

    assertEquals(chance2.getProbability(), chance1.notAChance());
  }
}