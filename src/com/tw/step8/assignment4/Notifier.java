package com.tw.step8.assignment4;

public class Notifier {

  public boolean notify(Observer observer, ParkingLot parkingLot, Status status) {
    observer.notify(parkingLot, status);
    return true;
  }
}
