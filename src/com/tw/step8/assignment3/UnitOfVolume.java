package com.tw.step8.assignment3;

public enum UnitOfVolume {
  LITRE(1), GALLON(3.178);

  final double value;

  UnitOfVolume(double value) {
    this.value = value;
  }

}
