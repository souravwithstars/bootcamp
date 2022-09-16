package com.tw.step8.assignment4.exception;

public class SizeNotAllowedException extends Throwable {
  private final int size;

  public SizeNotAllowedException(int size) {
    this.size = size;
  }

  @Override
  public String getMessage() {
    return String.format("%d is not allowed, Minimum size is 1",this.size);
  }
}
