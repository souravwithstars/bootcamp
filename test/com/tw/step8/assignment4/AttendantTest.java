package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.NoParkingSpaceException;
import com.tw.step8.assignment4.exception.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {
  @Test
  void shouldParkACarIfSlotIsAvailable() throws ParkingLotFullException, NoParkingSpaceException {
    Attendant attendant = new Attendant(new ParkingLot[]{ParkingLot.create(1), ParkingLot.create(1)});
    Car car = new Car();

    assertTrue(attendant.park(car));
  }

  @Test
  void shouldThrowExceptionIfParkingSlotIsUnavailable() throws ParkingLotFullException, NoParkingSpaceException {
    Attendant attendant = new Attendant(new ParkingLot[]{ParkingLot.create(1)});
    Car firstCar = new Car();
    Car secondCar = new Car();

    assertTrue(attendant.park(firstCar));
    assertThrows(NoParkingSpaceException.class, ()->attendant.park(secondCar));
  }

}