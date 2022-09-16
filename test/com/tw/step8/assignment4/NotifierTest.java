package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.SizeNotAllowedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {
  @Test
  void shouldNotifyAllAttendantsWhenParkingLotIsFull() throws SizeNotAllowedException {
    Attendant[] attendants = {new Attendant(), new Attendant()};
    Manager manager = new Manager();
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = ParkingLot.create(1, attendants, manager, notifier);

    assertTrue(notifier.notify(manager,parkingLot,Capacity.FULL));
  }
}