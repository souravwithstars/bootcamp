package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.SizeNotAllowedException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Observer;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {
  @Test
  void shouldNotifyManagerWhenParkingLotIsEightyPercent() throws SizeNotAllowedException {
    Manager manager = new Manager("m-1"){
      @Override
      public void notify(ParkingLot parkingLot, Status status) {
        assertEquals(status , Status.EIGHTY_PERCENT);
      }
    };
    Notifier notifier = new Notifier();
    notifier.add(Status.EIGHTY_PERCENT, manager);
    ParkingLot parkingLot = ParkingLot.create(1,notifier);

    assertTrue(notifier.notify(parkingLot, Status.EIGHTY_PERCENT));
  }

  @Test
  void shouldNotifyManagerWhenParkingLotIsTwentyPercent() throws SizeNotAllowedException {
    Manager manager = new Manager("m-1"){
      @Override
      public void notify(ParkingLot parkingLot, Status status) {
        assertEquals(status , Status.TWENTY_PERCENT);
      }
    };
    Notifier notifier = new Notifier();
    notifier.add(Status.TWENTY_PERCENT, manager);
    ParkingLot parkingLot = ParkingLot.create(1,notifier);

    assertTrue(notifier.notify(parkingLot, Status.TWENTY_PERCENT));
  }

  @Test
  void shouldNotifyAttendantsWhenParkingLotIsFull() throws SizeNotAllowedException {
    Attendant firstAttendant = new Attendant("a-1"){
      @Override
      public void notify(ParkingLot parkingLot, Status status) {
        assertEquals(status , Status.FULL);
      }
    };

    Attendant secondAttendant = new Attendant("a-2"){
      @Override
      public void notify(ParkingLot parkingLot, Status status) {
        assertEquals(status , Status.FULL);
      }
    };

    Notifier notifier = new Notifier();
    notifier.add(Status.FULL, firstAttendant);
    notifier.add(Status.FULL, secondAttendant);
    ParkingLot parkingLot = ParkingLot.create(1,notifier);

    assertTrue(notifier.notify(parkingLot, Status.FULL));
  }

  @Test
  void shouldNotifyCivicBodyWhenParkingLotIsEightyPercent() throws SizeNotAllowedException {
    CivicBody civicBody = new CivicBody("cb-1"){
      @Override
      public void notify(ParkingLot parkingLot, Status status) {
        assertEquals(status , Status.EIGHTY_PERCENT);
      }
    };
    Notifier notifier = new Notifier();
    notifier.add(Status.EIGHTY_PERCENT, civicBody);

    ParkingLot parkingLot = ParkingLot.create(1, notifier);

    assertTrue(notifier.notify(parkingLot, Status.EIGHTY_PERCENT));
  }
}