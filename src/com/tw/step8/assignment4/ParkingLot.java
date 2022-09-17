package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;
import com.tw.step8.assignment4.exception.SizeNotAllowedException;

import java.util.ArrayList;

class ParkingLot {
  private final int size;
  private final ArrayList<Car> parkingSlots;
  private final Notifier notifier;

  private ParkingLot(int size, Notifier notifier) {
    this.size = size;
    this.parkingSlots = new ArrayList<>(size);
    this.notifier = notifier;
  }

  public static ParkingLot create(int size, Notifier notifier) throws SizeNotAllowedException {
    if (size <= 0) {
      throw new SizeNotAllowedException(size);
    }
    return new ParkingLot(size, notifier);
  }

  private boolean isFull() {
    return this.parkingSlots.size() >= this.size;
  }

  public boolean park(Car car) throws ParkingLotFullException {
    if (this.isFull()) {
      throw new ParkingLotFullException(this.size);
    }

    this.parkingSlots.add(car);

    notifyForSlotFull();
    notifyForEightyPercent();
    notifyForTwentyPercent();

    return true;
  }

  private void notifyForTwentyPercent() {
    if (this.parkingSlots.size() <= 0.2 * this.size) {
      notifier.notify(this, Status.TWENTY_PERCENT);
    }
  }

  private void notifyForEightyPercent() {
    if (this.parkingSlots.size() >= 0.8 * this.size) {
      notifier.notify(this, Status.EIGHTY_PERCENT);
    }
  }

  private void notifyForSlotFull() {
    if (this.isFull()) {
      notifier.notify(this, Status.FULL);
    }
  }
}
