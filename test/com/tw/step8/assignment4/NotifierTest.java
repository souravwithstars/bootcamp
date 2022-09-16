package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.SizeNotAllowedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {
  @Test
  void shouldNotifyManagerWhenParkingLotIsEightyPercent() throws SizeNotAllowedException {
    Attendant[] attendants = {new Attendant(), new Attendant()};
    Manager manager = new Manager(){
      @Override
      public void notify(ParkingLot parkingLot, Status status) {
        assertEquals(status , Status.EIGHTY_PERCENT);
      }
    };
    CivicBody civicBody = new CivicBody();
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, attendants, manager, civicBody, notifier);

    assertTrue(notifier.notify(manager,parkingLot, Status.EIGHTY_PERCENT));
  }

  @Test
  void shouldNotifyCivicBodyWhenParkingLotIsEightyPercent() throws SizeNotAllowedException {
    Attendant[] attendants = {new Attendant(), new Attendant()};
    Manager manager = new Manager();
    CivicBody civicBody = new CivicBody(){
      @Override
      public void notify(ParkingLot parkingLot, Status status) {
        assertEquals(status , Status.EIGHTY_PERCENT);
      }
    };
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, attendants, manager, civicBody, notifier);

    assertTrue(notifier.notify(civicBody,parkingLot, Status.EIGHTY_PERCENT));
  }
}