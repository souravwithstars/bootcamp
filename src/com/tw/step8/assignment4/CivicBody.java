package com.tw.step8.assignment4;

public class CivicBody implements Observer{
  private final String id;

  public CivicBody(String id) {
    this.id = id;
  }

  @Override
  public void notify(ParkingLot parkingLot, Status status) {
    // Got Notification
  }
}
