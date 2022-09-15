package com.tw.step8.compare;

import com.tw.step8.compare.exception.InvalidStandardException;

public class Length {

  private final double value;
  private final UnitOfLength unit;

  private Length(double value, UnitOfLength unit) {
    this.value = value;
    this.unit = unit;
  }

  public static Length create(double value, UnitOfLength unitOfLength) throws InvalidStandardException {
    if (value <= 0) {
      throw new InvalidStandardException(value);
    }
    return new Length(value, unitOfLength);
  }

  public int compare(Length otherLength) {
    double inCentimeter = this.unit.value * this.value;
    double otherLengthInCentimeter = otherLength.unit.value * otherLength.value;

    if (inCentimeter == otherLengthInCentimeter) return 0;

    return inCentimeter > otherLengthInCentimeter ? 1 : -1;
  }
}
