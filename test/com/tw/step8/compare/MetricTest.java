package com.tw.step8.compare;

import com.tw.step8.compare.exception.InvalidStandardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetricTest {
  @Test
  void shouldReturnZeroIfBothAreSame() throws InvalidStandardException {
    Metric feet = Metric.create(1, UnitOfLength.FEET);
    Metric inch = Metric.create(12, UnitOfLength.INCH);

    int comparisonResult = feet.compare(inch);

    assertEquals(0, comparisonResult);
  }

  @Test
  void shouldReturnOneIfFirstLengthIsGreater() throws InvalidStandardException {
    Metric feet = Metric.create(2, UnitOfLength.FEET);
    Metric inch = Metric.create(12, UnitOfLength.INCH);

    int comparisonResult = feet.compare(inch);

    assertEquals(1, comparisonResult);
  }

  @Test
  void shouldReturnMinusOneIfFirstLengthIsSmaller() throws InvalidStandardException {
    Metric feet = Metric.create(1, UnitOfLength.FEET);
    Metric inch = Metric.create(13, UnitOfLength.INCH);

    int comparisonResult = feet.compare(inch);

    assertEquals(-1, comparisonResult);
  }

  @Test
  void shouldAddTwoLengthsOfSameUnit() throws InvalidStandardException {
    Metric oneInch = Metric.create(1, UnitOfLength.INCH);
    Metric twoInch = Metric.create(2, UnitOfLength.INCH);
    Metric expected = Metric.create(3, UnitOfLength.INCH);

    Metric actual = oneInch.add(twoInch);

    assertTrue(expected.isDifferenceInDelta(actual, 0.01));
  }

  @Test
  void shouldAddTwoLengthsOfDifferentUnit() throws InvalidStandardException {
    Metric oneInch = Metric.create(1, UnitOfLength.INCH);
    Metric centimeter = Metric.create(2.5, UnitOfLength.CM);
    Metric expected = Metric.create(2, UnitOfLength.INCH);

    Metric actual = oneInch.add(centimeter);

    assertTrue(expected.isDifferenceInDelta(actual, 0.01));
  }

  @Test
  void shouldThrowExceptionForInvalidValues() {
    assertThrows(InvalidStandardException.class, () -> Metric.create(-5, UnitOfLength.MM));
  }
}