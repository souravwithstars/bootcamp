package com.tw.step8.assignment3;

public class Temperature {
  private final double value;
  private final UnitOfTemperature unit;

  private Temperature(double value, UnitOfTemperature unit) {
    this.value = value;
    this.unit = unit;
  }

  public static Temperature create(double value, UnitOfTemperature unit) {
    return new Temperature(value, unit);
  }

  public Rank compare(Temperature temperature) {
    double inCelsius = this.isCelsius() ? this.value : this.convertToCelsius();
    double otherTemperatureInCelsius = temperature.isCelsius() ? temperature.value : temperature.convertToCelsius();

    if(inCelsius==otherTemperatureInCelsius) return Rank.EQUAL;

    return inCelsius > otherTemperatureInCelsius ? Rank.GREATER : Rank.LESSER;
  }

  private boolean isCelsius() {
    return this.unit == UnitOfTemperature.CELSIUS;
  }

  private double convertToCelsius() {
    return (this.value - 32) * (5 / 9.0);
  }
}
