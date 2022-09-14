package com.tw.step8.toss;

public class Coins {
  private final int count;

  public Coins(int count) {
    this.count = count;
  }

  public double chanceOfAllTails() {
    int noOfCoins = getNoOfCoins();
    double chance = Math.pow(0.5, noOfCoins);
    return chance;
  }

  public double chanceOfAtleastOneTails() {
    int noOfCoins = getNoOfCoins();
    double chance = 1 - Math.pow(0.5, noOfCoins);
    return chance;
  }

  private int getNoOfCoins() {
    return count;
  }
}
