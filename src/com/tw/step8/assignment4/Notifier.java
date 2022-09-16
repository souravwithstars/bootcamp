package com.tw.step8.assignment4;

public class Notifier {

  public boolean notify(Observer observer,ParkingLot parkingLot,Capacity capacity) {
    observer.notify(parkingLot, capacity);
    return true;
  }
}
