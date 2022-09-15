package com.tw.step8.compare.exception;

public class InvalidStandardException extends Throwable {
  private final double higherMetric;
  private final double lowerMetric;

  public InvalidStandardException(double higherMetric, double lowerMetric) {
    super();
    this.higherMetric = higherMetric;
    this.lowerMetric = lowerMetric;
  }

  @Override
  public String getMessage() {
    return String.format("Can not set values below 1, %d and %d", this.higherMetric, this.lowerMetric);
  }
}
