package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;
import com.tw.step8.assignment4.exception.SizeNotAllowedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
  @Test
  void shouldParkACarIfParkingSlotIsAvailable() throws ParkingLotFullException, SizeNotAllowedException {
    ParkingLot parkingLot = ParkingLot.create(2);
    Car car = new Car();

    assertTrue(parkingLot.park(car));
  }

  @Test
  void shouldThrowExceptionWhenSlotIsNotAvailable() throws ParkingLotFullException, SizeNotAllowedException {
    ParkingLot parkingLot = ParkingLot.create(1);
    Car firstCar = new Car();
    Car secondCar = new Car();

    assertTrue(parkingLot.park(firstCar));
    assertThrows(ParkingLotFullException.class, ()-> parkingLot.park(secondCar));
  }

  @Test
  void shouldInformIfParkingSlotIsUnavailable() throws ParkingLotFullException, SizeNotAllowedException {
    ParkingLot parkingLot = ParkingLot.create(1);
    Car car = new Car();

    parkingLot.park(car);

    assertTrue(parkingLot.isFull());
  }

  @Test
  void shouldInformIfParkingSlotIsAvailable() throws SizeNotAllowedException {
    ParkingLot parkingLot = ParkingLot.create(1);

    assertFalse(parkingLot.isFull());
  }

  @Test
  void shouldThrowAnExceptionIfSizeIsLessThanOne() {
    assertThrows(SizeNotAllowedException.class,()-> ParkingLot.create(-1));
  }
}