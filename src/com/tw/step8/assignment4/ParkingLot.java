package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;

import java.util.ArrayList;

public class ParkingLot {
  private final int size;
  private final ArrayList<Car> parkingSlots;

  private ParkingLot(int size) {
    this.size = size;
    this.parkingSlots = new ArrayList<Car>(size);
  }

  public static ParkingLot create(int limit) {
    return new ParkingLot(limit);
  }

  public boolean isFull() {
    return this.parkingSlots.size() >= this.size;
  }

  public boolean park(Car car) throws ParkingLotFullException {
    if (this.isFull()){
      throw new ParkingLotFullException(this.size);
    }
    this.parkingSlots.add(car);
    return true;
  }
}
