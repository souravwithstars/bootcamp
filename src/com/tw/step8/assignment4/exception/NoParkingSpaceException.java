package com.tw.step8.assignment4.exception;

public class NoParkingSpaceException extends Throwable {
  public NoParkingSpaceException() {
    super();
  }

  @Override
  public String getMessage() {
    return "No parking slots are available";
  }
}
