package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidStandardException;

public class Volume {
  private final double value;
  private final UnitOfVolume unit;

  private Volume(double value, UnitOfVolume unit) {
    this.value = value;
    this.unit = unit;
  }

  public static Volume create(double value, UnitOfVolume unitOfVolume) throws InvalidStandardException {
    if (value < 0) {
      throw new InvalidStandardException(value);
    }
    return new Volume(value, unitOfVolume);
  }

  public Rank compare(Volume otherVolume) {
    double inLitre = this.unit.value * this.value;
    double otherVolumeInLitre= otherVolume.unit.value * otherVolume.value;

    if (inLitre == otherVolumeInLitre) return Rank.EQUAL;

    return inLitre > otherVolumeInLitre? Rank.GREATER : Rank.LESSER;
  }

  public Volume add(Volume otherVolume) throws InvalidStandardException {
    double inLitre = this.unit.value * this.value;
    double otherVolumeInLitre= otherVolume.unit.value * otherVolume.value;
    double totalInLitre= inLitre + otherVolumeInLitre;

    return Volume.create(totalInLitre, UnitOfVolume.LITRE);
  }

  public boolean isDifferenceInDelta(Volume otherVolume, double delta) {
    return Math.abs(this.value - otherVolume.value) <= delta;
  }
}
