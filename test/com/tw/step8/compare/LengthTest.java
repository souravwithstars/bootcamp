package com.tw.step8.compare;

import com.tw.step8.compare.exception.InvalidStandardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
  @Test
  void shouldReturnZeroIfBothAreSame() throws InvalidStandardException {
    Length feet = Length.create(1, UnitOfLength.FEET);
    Length inch = Length.create(12, UnitOfLength.INCH);

    int comparisonResult = feet.compare(inch);

    assertEquals(0, comparisonResult);
  }

  @Test
  void shouldReturnOneIfFirstLengthIsGreater() throws InvalidStandardException {
    Length feet = Length.create(2, UnitOfLength.CM);
    Length inch = Length.create(12, UnitOfLength.MM);

    int comparisonResult = feet.compare(inch);

    assertEquals(1, comparisonResult);
  }

  @Test
  void shouldReturnMinusOneIfFirstLengthIsSmaller() throws InvalidStandardException {
    Length feet = Length.create(1, UnitOfLength.CM);
    Length inch = Length.create(12, UnitOfLength.MM);

    int comparisonResult = feet.compare(inch);

    assertEquals(-1, comparisonResult);
  }

  @Test
  void shouldThrowExceptionForInvalidValues() {
    assertThrows(InvalidStandardException.class, () -> Length.create(-5, UnitOfLength.MM));
  }
}