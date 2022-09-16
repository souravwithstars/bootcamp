package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
  @Test
  void shouldParkACarIfParkingSlotIsAvailable() throws ParkingLotFullException {
    ParkingLot parkingLot = ParkingLot.create(2);
    Car car = new Car();

    assertTrue(parkingLot.park(car));
  }

  @Test
  void shouldThrowExceptionWhenSlotIsNotAvailable() throws ParkingLotFullException {
    ParkingLot parkingLot = ParkingLot.create(1);
    Car firstCar = new Car();
    Car secondCar = new Car();

    assertTrue(parkingLot.park(firstCar));
    assertThrows(ParkingLotFullException.class, ()-> parkingLot.park(secondCar));
  }
}