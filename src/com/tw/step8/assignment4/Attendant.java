package com.tw.step8.assignment4;

public class Attendant implements Observer{

  private final String id;

  public Attendant(String id) {
    this.id = id;
  }

  public void notify(ParkingLot parkingLot, Status status) {
    // Got notification
  }
}
