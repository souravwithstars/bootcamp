package com.tw.step8.toss;

public class Coins {
  private final FareCoin[] fareCoins;

  public Coins(FareCoin[] fareCoins) {
    this.fareCoins = fareCoins;
  }

  public double chanceOfAllTails() {
    double chance = 1;
    for (FareCoin fareCoin : fareCoins) {
      chance = chance * fareCoin.chanceOfTails();
    }
    return chance;
  }
}
