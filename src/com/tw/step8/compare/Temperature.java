package com.tw.step8.compare;

import com.tw.step8.compare.exception.InvalidStandardException;

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

  public Outcome compare(Temperature temperature) {
    double inCelsius = this.isCelsius() ? this.value : this.convertToCelsius();
    double otherTemperatureInCelsius = temperature.isCelsius() ? temperature.value : temperature.convertToCelsius();

    if(inCelsius==otherTemperatureInCelsius) return Outcome.EQUAL;

    return inCelsius > otherTemperatureInCelsius ? Outcome.GREATERTHAN : Outcome.LESSERTHAN;
  }

  private boolean isCelsius() {
    return this.unit == UnitOfTemperature.CELSIUS;
  }

  private double convertToCelsius() {
    return (this.value - 32) * (5 / 9.0);
  }
}
