package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {
  @Test
  void shouldParkACarIfSlotIsAvailable() throws ParkingLotFullException {
    Attendant attendant = new Attendant(ParkingLot.create(1));
    Car car = new Car();

    assertTrue(attendant.park(car));
  }

  @Test
  void shouldThrowExceptionIfParkingSlotIsUnavailable() throws ParkingLotFullException {
    Attendant attendant = new Attendant(ParkingLot.create(1));
    Car firstCar = new Car();
    Car secondCar = new Car();

    assertTrue(attendant.park(firstCar));
    assertThrows(ParkingLotFullException.class, ()->attendant.park(secondCar));
  }

}