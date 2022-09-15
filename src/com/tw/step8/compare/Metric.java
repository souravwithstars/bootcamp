package com.tw.step8.compare;

import com.tw.step8.compare.exception.InvalidStandardException;

public class Metric {
  private final double factor;

  private Metric(double higherMetric, double lowerMetric) {
    this.factor = lowerMetric / higherMetric;
  }

  public static Metric setMetrics(double higherMetric, double lowerMetric) throws InvalidStandardException {
    if(higherMetric <= 0 || lowerMetric <= 0){
      throw new InvalidStandardException(higherMetric, lowerMetric);
    }
    return new Metric(higherMetric, lowerMetric);
  }

  public boolean compare(double higherMetric, double lowerMetric) {
    return higherMetric * this.factor == lowerMetric;
  }
}
