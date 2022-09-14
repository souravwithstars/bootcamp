package com.tw.step8.toss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FareCoinTest {

  @Test
  void ShouldGiveChanceOfGettingTailsForTwoCoins() {
    FareCoin[] fareCoins = new FareCoin[] {new FareCoin(), new FareCoin()};
    Coins coins = new Coins(fareCoins);
    assertEquals(0.25, coins.chanceOfAllTails());
  }
}