package com.tw.step8.assignment4;

import java.util.HashMap;
import java.util.ArrayList;

public class Notifier {
  final HashMap<Status, ArrayList<Observer>> mapper;

  public Notifier() {
    this.mapper = new HashMap<Status, ArrayList<Observer>>();
  }

  public void add(Status status, Observer observer) {
    ArrayList<Observer> observers = mapper.get(status);

    if (observers == null) {
      ArrayList<Observer> observersList = new ArrayList<>();
      observersList.add(observer);

      mapper.put(status, observersList);
      return;
    }

    observers.add(observer);
  }

  public boolean notify(ParkingLot parkingLot, Status status) {
    ArrayList<Observer> observers = mapper.get(status);

    if (observers == null){
      return false;
    }

    for (Observer observer : observers) {
      observer.notify(parkingLot, status);
    }
    return true;
  }
}
