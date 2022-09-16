package com.tw.step8.assignment3.exception;

public class InvalidStandardException extends Throwable {
  private final double value;

  public InvalidStandardException(double value) {
    super();
    this.value = value;
  }

  @Override
  public String getMessage() {
    return String.format("Can not set values below 1, %d", this.value);
  }
}
