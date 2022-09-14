package com.tw.step8.toss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

  @Test
  void ShouldGiveChanceOfGettingTailsForOneCoin() {
    Coins coins = new Coins(1);
    assertEquals(0.5, coins.chanceOfAllTails());
  }

  @Test
  void ShouldGiveChanceOfGettingTailsForTwoCoins() {
    Coins coins = new Coins(2);
    assertEquals(0.25, coins.chanceOfAllTails());
  }

  @Test
  void ShouldGiveChanceOfGettingAtLeastOneTailsForTwoCoins() {
    Coins coins = new Coins(2);
    assertEquals(0.75, coins.chanceOfAtleastOneTails());
  }
}