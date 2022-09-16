package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;
import com.tw.step8.assignment4.exception.SizeNotAllowedException;

import java.util.ArrayList;

class ParkingLot {
  private final int size;
  private final ArrayList<Car> parkingSlots;

  private ParkingLot(int size) {
    this.size = size;
    this.parkingSlots = new ArrayList<>(size);
  }

  public static ParkingLot create(int size) throws SizeNotAllowedException {
    if (size <= 0){
      throw new SizeNotAllowedException(size);
    }
    return new ParkingLot(size);
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
