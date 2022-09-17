package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;
import com.tw.step8.assignment4.exception.SizeNotAllowedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
  @Test
  void shouldParkACarIfParkingSlotIsAvailable() throws SizeNotAllowedException, ParkingLotFullException {
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, notifier);
    Car car = new Car("c-1");

    assertTrue(parkingLot.park(car));
  }

  @Test
  void shouldThrowExceptionWhenSlotIsNotAvailable() throws ParkingLotFullException, SizeNotAllowedException {
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, notifier);
    Car firstCar = new Car("c-1");
    Car secondCar = new Car("c-2");

    assertTrue(parkingLot.park(firstCar));
    assertThrows(ParkingLotFullException.class, () -> parkingLot.park(secondCar));
  }

  @Test
  void shouldThrowAnExceptionIfSizeIsLessThanOne() {
    Notifier notifier = new Notifier();
    assertThrows(SizeNotAllowedException.class, () -> ParkingLot.create(-1, notifier));
  }
}