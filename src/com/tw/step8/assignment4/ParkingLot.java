package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;
import com.tw.step8.assignment4.exception.SizeNotAllowedException;

import java.util.ArrayList;

class ParkingLot {
  private final int size;
  private final ArrayList<Car> parkingSlots;
  private final Attendant[] attendants;
  private final Manager manager;
  private final Notifier notifier;

  private ParkingLot(int size, Attendant[] attendants, Manager manager, Notifier notifier) {
    this.size = size;
    this.parkingSlots = new ArrayList<>(size);
    this.attendants = attendants;
    this.manager = manager;
    this.notifier = notifier;
  }

  public static ParkingLot create(int size, Attendant[] attendants, Manager manager, Notifier notifier) throws SizeNotAllowedException {
    if (size <= 0) {
      throw new SizeNotAllowedException(size);
    }
    return new ParkingLot(size, attendants, manager, notifier);
  }

  public boolean isFull() {
    return this.parkingSlots.size() >= this.size;
  }

  public boolean park(Car car) throws ParkingLotFullException {
    if (this.isFull()) {
     throw new ParkingLotFullException(this.size);
    }
    this.parkingSlots.add(car);

    if (this.isFull()) {
      for (Attendant attendant : attendants) {
        notifier.notify(attendant, this, Capacity.FULL);
      }
    }

    if (this.parkingSlots.size() >= 0.8 * this.size) {
      notifier.notify(manager, this, Capacity.EIGHTY_PERCENT);
    }

    if (this.parkingSlots.size() <= 0.2 * this.size) {
      notifier.notify(manager, this, Capacity.TWENTY_PERCENT);
    }

    return true;
  }
}
