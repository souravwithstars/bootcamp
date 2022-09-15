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

  public Outcome compare(Length otherLength) {
    double inCentimeter = this.unit.value * this.value;
    double otherLengthInCentimeter = otherLength.unit.value * otherLength.value;

    if (inCentimeter == otherLengthInCentimeter) return Outcome.EQUAL;

    return inCentimeter > otherLengthInCentimeter ? Outcome.GREATERTHAN : Outcome.LESSERTHAN;
  }

  public Length add(Length otherLength) throws InvalidStandardException {
    double inCentimeter = this.unit.value * this.value;
    double otherLengthInCentimeter = otherLength.unit.value * otherLength.value;
    double totalInCentimeter = inCentimeter + otherLengthInCentimeter;
    double totalInInches = totalInCentimeter / UnitOfLength.INCH.value;

    return Length.create(totalInInches, UnitOfLength.INCH);
  }

  public boolean isDifferenceInDelta(Length otherLength, double delta) {
    return Math.abs(this.value - otherLength.value) <= delta;
  }
}
