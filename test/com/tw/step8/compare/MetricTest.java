package com.tw.step8.compare;

import com.tw.step8.compare.exception.InvalidStandardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetricTest {
  @Test
  void shouldReturnTrueIfBothMetricsAreEqual() throws InvalidStandardException {
    Metric feetToInches = Metric.setMetrics(1, 12);
    Metric inchesToCentimeter = Metric.setMetrics(2, 5);
    Metric centimeterToMillimeter = Metric.setMetrics(1, 10);

    assertTrue(feetToInches.compare(2, 24));
    assertTrue(inchesToCentimeter.compare(12, 30));
    assertTrue(centimeterToMillimeter.compare(2.5, 25));
  }

  @Test
  void shouldReturnFalseIfBothMetricsAreNotEqual() throws InvalidStandardException {
    Metric feetToInches = Metric.setMetrics(1, 12);
    Metric inchesToCentimeter = Metric.setMetrics(2, 5);
    Metric centimeterToMillimeter = Metric.setMetrics(1, 10);

    assertFalse(feetToInches.compare(2, 25));
    assertFalse(inchesToCentimeter.compare(12, 25));
    assertFalse(centimeterToMillimeter.compare(2.5, 20));
  }

  @Test
  void shouldThrowExceptionForInvalidValues() {
   assertThrows(InvalidStandardException.class,() -> Metric.setMetrics(5, -5));
  }
}