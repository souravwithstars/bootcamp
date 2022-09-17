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

  @Test
  void shouldNotifyObserversWhenParkingLotIsTwentyPercent() throws SizeNotAllowedException {
    Manager manager = new Manager("m-1");
    Notifier notifier = new Notifier() {
      @Override
      public boolean notify(ParkingLot parkingLot, Status status) {
        assertEquals(status, Status.TWENTY_PERCENT);
        return true;
      }
    };
    notifier.add(Status.TWENTY_PERCENT, manager);
    ParkingLot parkingLot = ParkingLot.create(1, notifier);

    assertTrue(notifier.notify(parkingLot, Status.TWENTY_PERCENT));
  }

  @Test
  void shouldNotifyObserversWhenParkingLotIsEightyPercent() throws SizeNotAllowedException {
    Manager manager = new Manager("m-1");

    Notifier notifier = new Notifier() {
      @Override
      public boolean notify(ParkingLot parkingLot, Status status) {
        assertEquals(status, Status.EIGHTY_PERCENT);
        return true;
      }
    };
    notifier.add(Status.EIGHTY_PERCENT, manager);

    ParkingLot parkingLot = ParkingLot.create(1, notifier);

    assertTrue(notifier.notify(parkingLot, Status.EIGHTY_PERCENT));
  }

  @Test
  void shouldNotifyObserversWhenParkingLotIsFull() throws SizeNotAllowedException {
    Attendant attendant = new Attendant("a-1");

    Notifier notifier = new Notifier() {
      @Override
      public boolean notify(ParkingLot parkingLot, Status status) {
        assertEquals(status, Status.FULL);
        return true;
      }
    };
    notifier.add(Status.FULL, attendant);

    ParkingLot parkingLot = ParkingLot.create(1, notifier);

    assertTrue(notifier.notify(parkingLot, Status.FULL));
  }
}