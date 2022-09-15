package com.tw.step8.compare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetricTest {
  @Test
  void shouldReturnTrueIfBothMetricsAreEqual() {
    Metric feetToInches = Metric.setMetrics(1, 12);
    Metric inchesToCentimeter = Metric.setMetrics(2, 5);

    assertTrue(feetToInches.compare(2, 24));
    assertTrue(inchesToCentimeter.compare(12, 30));
  }

  @Test
  void shouldReturnFalseIfBothMetricsAreNotEqual() {
    Metric feetToInches = Metric.setMetrics(1, 12);
    Metric inchesToCentimeter = Metric.setMetrics(2, 5);

    assertFalse(feetToInches.compare(2, 25));
    assertFalse(inchesToCentimeter.compare(12, 25));
  }
}