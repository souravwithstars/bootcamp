package com.tw.step8.toss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

  @Test
  void ShouldGiveChanceOfGettingTails() {
    Coins coins = new Coins(1);
    assertEquals(0.5, coins.chanceOfAllTails());

    Coins coins2 = new Coins(2);
    assertEquals(0.25, coins2.chanceOfAllTails());
  }

  @Test
  void ShouldGiveChanceOfNoTails() {
    Coins coins = new Coins(1);
    assertEquals(0.5, coins.chanceOfNoTails());

    Coins coins2 = new Coins(2);
    assertEquals(0.25, coins2.chanceOfNoTails());
  }

  @Test
  void ShouldGiveChanceOfGettingAtLeastOneTails() {
    Coins coins = new Coins(2);
    assertEquals(0.75, coins.chanceOfAtLeastOneTails());

    Coins coins2 = new Coins(3);
    assertEquals(0.875, coins2.chanceOfAtLeastOneTails());
  }
}