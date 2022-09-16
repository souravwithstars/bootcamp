package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;
import com.tw.step8.assignment4.exception.SizeNotAllowedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
  @Test
  void shouldParkACarIfParkingSlotIsAvailable() throws SizeNotAllowedException, ParkingLotFullException {
    Attendant[] attendants = {new Attendant(), new Attendant()};
    Manager manager = new Manager();
    CivicBody civicBody = new CivicBody();
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, attendants, manager, civicBody, notifier);
    Car car = new Car();

    assertTrue(parkingLot.park(car));
  }

  @Test
  void shouldThrowExceptionWhenSlotIsNotAvailable() throws ParkingLotFullException, SizeNotAllowedException {
    Attendant[] attendants = {new Attendant(), new Attendant()};
    Manager manager = new Manager();
    CivicBody civicBody = new CivicBody();
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, attendants, manager, civicBody, notifier);
    Car firstCar = new Car();
    Car secondCar = new Car();

    assertTrue(parkingLot.park(firstCar));
    assertThrows(ParkingLotFullException.class, () -> parkingLot.park(secondCar));
  }

  @Test
  void shouldInformIfParkingSlotIsUnavailable() throws ParkingLotFullException, SizeNotAllowedException {
    Attendant[] attendants = {new Attendant(), new Attendant()};
    Manager manager = new Manager();
    CivicBody civicBody = new CivicBody();
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, attendants, manager, civicBody, notifier);
    Car car = new Car();

    parkingLot.park(car);

    assertTrue(parkingLot.isFull());
  }

  @Test
  void shouldInformIfParkingSlotIsAvailable() throws SizeNotAllowedException {
    Attendant[] attendants = {new Attendant(), new Attendant()};
    Manager manager = new Manager();
    CivicBody civicBody = new CivicBody();
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, attendants, manager, civicBody, notifier);

    assertFalse(parkingLot.isFull());
  }

  @Test
  void shouldThrowAnExceptionIfSizeIsLessThanOne() {
    Attendant[] attendants = {new Attendant(), new Attendant()};
    Manager manager = new Manager();
    CivicBody civicBody = new CivicBody();
    Notifier notifier = new Notifier();
    assertThrows(SizeNotAllowedException.class, () -> ParkingLot.create(-1, attendants, manager, civicBody, notifier));
  }
}