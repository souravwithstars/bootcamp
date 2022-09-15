package com.tw.step8.chance;

import com.tw.step8.chance.exception.InvalidProbabilityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

  @Test
  void ShouldRepresentChanceOfGettingTails() throws InvalidProbabilityException {
    Chance chance = Chance.createChance(0.5);
    Chance chance2 = Chance.createChance(0.5);

    assertTrue(chance.equals(chance2));
  }

  @Test
  void ShouldNotRepresentAChance() {
    assertThrows(InvalidProbabilityException.class, () -> Chance.createChance(2));
  }

  @Test
  void ShouldRepresentChanceOfNotGettingTails() throws InvalidProbabilityException {
    Chance chance1 = Chance.createChance(0.4);
    Chance chance2 = Chance.createChance(0.6);

    assertTrue(chance2.equals(chance1.notAChance()));
  }

  @Test
  void combineChance() throws InvalidProbabilityException {
    Chance chance1 = Chance.createChance(0.5);
    Chance chance2 = Chance.createChance(0.5);

    Chance expected = Chance.createChance(0.25);
    assertTrue(expected.equals(chance1.combineChance(chance2)));
  }
}