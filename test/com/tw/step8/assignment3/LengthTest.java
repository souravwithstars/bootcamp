package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidStandardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
  @Test
  void shouldReturnOutcomeOfEqualIfBothAreSame() throws InvalidStandardException {
    Length feet = Length.create(1, UnitOfLength.FEET);
    Length inch = Length.create(12, UnitOfLength.INCH);

    Rank comparisonResult = feet.compare(inch);

    assertEquals(Rank.EQUAL, comparisonResult);
  }

  @Test
  void shouldReturnOutcomeOfGreaterThanIfFirstLengthIsGreater() throws InvalidStandardException {
    Length feet = Length.create(2, UnitOfLength.FEET);
    Length inch = Length.create(12, UnitOfLength.INCH);

    Rank comparisonResult = feet.compare(inch);

    assertEquals(Rank.GREATER, comparisonResult);
  }

  @Test
  void shouldReturnOutcomeOfLesserThanIfFirstLengthIsLesser() throws InvalidStandardException {
    Length feet = Length.create(1, UnitOfLength.FEET);
    Length inch = Length.create(13, UnitOfLength.INCH);

    Rank comparisonResult = feet.compare(inch);

    assertEquals(Rank.LESSER, comparisonResult);
  }

  @Test
  void shouldAddTwoLengthsOfSameUnit() throws InvalidStandardException {
    Length oneInch = Length.create(1, UnitOfLength.INCH);
    Length twoInch = Length.create(2, UnitOfLength.INCH);
    Length expected = Length.create(3, UnitOfLength.INCH);

    Length actual = oneInch.add(twoInch);

    assertTrue(expected.isDifferenceInDelta(actual, 0.01));
  }

  @Test
  void shouldAddTwoLengthsOfDifferentUnit() throws InvalidStandardException {
    Length oneInch = Length.create(1, UnitOfLength.INCH);
    Length centimeter = Length.create(2.5, UnitOfLength.CM);
    Length expected = Length.create(2, UnitOfLength.INCH);

    Length actual = oneInch.add(centimeter);

    assertTrue(expected.isDifferenceInDelta(actual, 0.01));
  }

  @Test
  void shouldThrowExceptionForInvalidValues() {
    assertThrows(InvalidStandardException.class, () -> Length.create(-5, UnitOfLength.MM));
  }
}