package com.tw.step8.chance;

import com.tw.step8.chance.exception.InvalidProbabilityException;

public class Chance {
  private final double value;

  private Chance(double value) {
    this.value = value;
  }

  public static Chance createChance(double value) throws InvalidProbabilityException {
    if (value >= 1 || value <= 0) {
      throw new InvalidProbabilityException(value);
    }
    return new Chance(value);
  }

  public Chance combineChance(Chance anotherChance) {
    return new Chance(value * anotherChance.value);
  }

//  public Chance ___(){
//    return  new Chance(1 - Math.pow(this.notAChance(),2));
//  }

  public Chance notAChance() {
    return new Chance(1 - value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Chance chance = (Chance) o;

    return Double.compare(chance.value, value) == 0;
  }

  @Override
  public int hashCode() {
    long temp = Double.doubleToLongBits(value);
    return (int) (temp ^ (temp >>> 32));
  }
}
