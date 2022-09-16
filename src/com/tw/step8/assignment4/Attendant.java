package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.NoParkingSpaceException;
import com.tw.step8.assignment4.exception.ParkingLotFullException;

public class Attendant {
  private final ParkingLot[] parkingLots;

  public Attendant(ParkingLot[] parkingLots) {
    this.parkingLots = parkingLots;
  }

  public boolean park(Car car) throws ParkingLotFullException, NoParkingSpaceException {
    for (ParkingLot parkingLot : this.parkingLots) {
      if (!parkingLot.isFull()){
        return parkingLot.park(car);
      }
    }
    throw new NoParkingSpaceException();
  }
}
