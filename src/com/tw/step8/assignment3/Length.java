package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidStandardException;

public class Length {

  private final double value;
  private final UnitOfLength unit;

  private Length(double value, UnitOfLength unit) {
    this.value = value;
    this.unit = unit;
  }

  public static Length create(double value, UnitOfLength unitOfLength) throws InvalidStandardException {
    if (value < 0) {
      throw new InvalidStandardException(value);
    }
    return new Length(value, unitOfLength);
  }

  public Rank compare(Length otherLength) {
    double inCentimeter = this.unit.value * this.value;
    double otherLengthInCentimeter = otherLength.unit.value * otherLength.value;

    if (inCentimeter == otherLengthInCentimeter) return Rank.EQUAL;

    return inCentimeter > otherLengthInCentimeter ? Rank.GREATER : Rank.LESSER;
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
