package com.tw.step8.assignment4.exception;

public class ParkingLotFullException extends Throwable {
  private final int limit;

  public ParkingLotFullException(int limit) {
    super();
    this.limit = limit;
  }

  @Override
  public String getMessage() {
    return "Parking lot size exceeded, max limit is " + this.limit;
  }
}
