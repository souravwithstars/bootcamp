package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;

public class Attendant {
  private final ParkingLot parkingLot;

  public Attendant(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }

  public boolean park(Car car) throws ParkingLotFullException {
    this.parkingLot.park(car);
    return true;
  }
}
