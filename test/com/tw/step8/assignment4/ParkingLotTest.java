package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;
import com.tw.step8.assignment4.exception.SizeNotAllowedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
  @Test
  void shouldParkACarIfParkingSlotIsAvailable() throws SizeNotAllowedException, ParkingLotFullException {
    Attendant[] attendants = {new Attendant("a-1"), new Attendant("a-2")};
    Manager manager = new Manager("m-1");
    CivicBody civicBody = new CivicBody("cb-1");
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, attendants, manager, civicBody, notifier);
    Car car = new Car("c-1");

    assertTrue(parkingLot.park(car));
  }

  @Test
  void shouldThrowExceptionWhenSlotIsNotAvailable() throws ParkingLotFullException, SizeNotAllowedException {
    Attendant[] attendants = {new Attendant("a-1"), new Attendant("a-2")};
    Manager manager = new Manager("m-1");
    CivicBody civicBody = new CivicBody("cb-1");
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, attendants, manager, civicBody, notifier);
    Car firstCar = new Car("c-1");
    Car secondCar = new Car("c-2");

    assertTrue(parkingLot.park(firstCar));
    assertThrows(ParkingLotFullException.class, () -> parkingLot.park(secondCar));
  }

  @Test
  void shouldInformIfParkingSlotIsUnavailable() throws ParkingLotFullException, SizeNotAllowedException {
    Attendant[] attendants = {new Attendant("a-1"), new Attendant("a-2")};
    Manager manager = new Manager("m-1");
    CivicBody civicBody = new CivicBody("cb-1");
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, attendants, manager, civicBody, notifier);
    Car car = new Car("c-1");

    parkingLot.park(car);

    assertTrue(parkingLot.isFull());
  }

  @Test
  void shouldInformIfParkingSlotIsAvailable() throws SizeNotAllowedException {
    Attendant[] attendants = {new Attendant("a-1"), new Attendant("a-2")};
    Manager manager = new Manager("m-1");
    CivicBody civicBody = new CivicBody("cb-1");
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, attendants, manager, civicBody, notifier);

    assertFalse(parkingLot.isFull());
  }

  @Test
  void shouldThrowAnExceptionIfSizeIsLessThanOne() {
    Attendant[] attendants = {new Attendant("a-1"), new Attendant("a-2")};
    Manager manager = new Manager("m-1");
    CivicBody civicBody = new CivicBody("cb-1");
    Notifier notifier = new Notifier();
    assertThrows(SizeNotAllowedException.class, () -> ParkingLot.create(-1, attendants, manager, civicBody, notifier));
  }
}