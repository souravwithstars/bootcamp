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