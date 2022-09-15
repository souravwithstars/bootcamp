package com.tw.step8.compare;

public class Metric {
  private final double higherMetric;
  private final double lowerMetric;
  private final double factor;

  private Metric(double higherMetric, double lowerMetric) {
    this.higherMetric = higherMetric;
    this.lowerMetric = lowerMetric;
    this.factor = this.lowerMetric / this.higherMetric;
  }

  public static Metric setMetrics(double higherMetric, double lowerMetric) {
    return new Metric(higherMetric, lowerMetric);
  }

  public boolean compare(double higherMetric, double lowerMetric) {
    return higherMetric * this.factor == lowerMetric;
  }
}
