package com.tw.step8.toss;

public class Coins {
  private final double probabilityOfEachFace;
  private final int count;

  public Coins(double probabilityOfEachFace, int count) {
    this.probabilityOfEachFace = probabilityOfEachFace;
    this.count = count;
  }

  public double chanceOfAllTails() {
    int noOfCoins = getNoOfCoins();
    double chance = Math.pow(probabilityOfEachFace, noOfCoins);
    return chance;
  }

  public double chanceOfAtLeastOneTails() {
    int noOfCoins = getNoOfCoins();
    double chance = 1 - Math.pow(probabilityOfEachFace, noOfCoins);
    return chance;
  }

  private int getNoOfCoins() {
    return count;
  }

  public double chanceOfNoTails() {
    return 1 - chanceOfAtLeastOneTails();
  }
}
