package com.tw.step8.compare;

import com.tw.step8.compare.exception.InvalidStandardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {

  @Test
  void shouldReturnZeroIfBothAreSame() throws InvalidStandardException {
    Volume gallon = Volume.create(1, UnitOfVolume.GALLON);
    Volume litre = Volume.create(3.178, UnitOfVolume.LITRE);

    int comparisonResult = gallon.compare(litre);

    assertEquals(0, comparisonResult);
  }
}