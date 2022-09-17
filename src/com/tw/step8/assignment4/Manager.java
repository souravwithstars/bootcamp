package com.tw.step8.assignment4;

public class Manager implements Observer{
  private final String id;

  public Manager(String id) {
    this.id = id;
  }

  public void notify(ParkingLot parkingLot, Status status) {
    // Got notification
  }
}
