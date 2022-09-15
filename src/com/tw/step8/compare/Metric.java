package com.tw.step8.compare;

import com.tw.step8.compare.exception.InvalidStandardException;

public class Metric {

  private final double value;
  private final UnitOfLength unit;

  private Metric(double value, UnitOfLength unit) {
    this.value = value;
    this.unit = unit;
  }

  public static Metric create(double value, UnitOfLength unitOfLength) throws InvalidStandardException {
    if (value <= 0) {
      throw new InvalidStandardException(value);
    }
    return new Metric(value, unitOfLength);
  }

  public int compare(Metric otherMetric) {
    double inCentimeter = this.unit.value * this.value;
    double otherLengthInCentimeter = otherMetric.unit.value * otherMetric.value;

    if (inCentimeter == otherLengthInCentimeter) return 0;

    return inCentimeter > otherLengthInCentimeter ? 1 : -1;
  }

  public Metric add(Metric otherMetric) throws InvalidStandardException {
    if (this.unit == otherMetric.unit){
      return Metric.create(this.value + otherMetric.value,this.unit);
    }

    double inCentimeter = this.unit.value * this.value;
    double otherLengthInCentimeter = otherMetric.unit.value * otherMetric.value;
    double totalInCentimeter = inCentimeter + otherLengthInCentimeter;
    double totalInInches = totalInCentimeter / UnitOfLength.INCH.value;

    return Metric.create(totalInInches, UnitOfLength.INCH);
  }

  public boolean isDifferenceInDelta(Metric otherMetric, double delta) {
    return Math.abs(this.value - otherMetric.value) <= delta;
  }
}
