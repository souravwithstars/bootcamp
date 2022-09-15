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

  public int compare(Temperature temperature) {
    return 0;
  }
}
