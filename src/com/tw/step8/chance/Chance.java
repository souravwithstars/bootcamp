package com.tw.step8.chance;

public class Chance {
  private final double probability;

  private Chance(double probability) {
    this.probability = probability;
  }

  public static Chance createChance(double probability) throws InvalidProbability {
    if(probability >= 1 || probability <= 0) {
      throw new InvalidProbability("Probability should be between 0-1");
    }
    return new Chance(probability);
  }

  public double getProbability() {
    return this.probability;
  }

  public double notAChance() {
    return 1 - probability;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Chance chance = (Chance) o;

    return Double.compare(chance.probability, probability) == 0;
  }

  @Override
  public int hashCode() {
    long temp = Double.doubleToLongBits(probability);
    return (int) (temp ^ (temp >>> 32));
  }
}
