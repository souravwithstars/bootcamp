package com.tw.step8.assignment3;

public enum UnitOfLength {
  FEET(30), INCH(2.5), CM(1), MM(0.1);

  final double value;

  UnitOfLength(double value) {
    this.value = value;
  }
}
