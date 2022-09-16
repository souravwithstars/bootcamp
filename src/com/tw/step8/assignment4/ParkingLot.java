package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;

import java.util.ArrayList;

public class ParkingLot {
  private final int limit;
  private final ArrayList<Car> parkingSlots;

  private ParkingLot(int limit) {
    this.limit = limit;
    this.parkingSlots = new ArrayList<Car>(limit);
  }

  public static ParkingLot create(int limit) {
    return new ParkingLot(limit);
  }

  public boolean park(Car car) throws ParkingLotFullException {
    if (parkingSlots.size() >= this.limit){
      throw new ParkingLotFullException(this.limit);
    }
    this.parkingSlots.add(car);
    return true;
  }
}
