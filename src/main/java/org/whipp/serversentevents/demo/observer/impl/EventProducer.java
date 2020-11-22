package org.whipp.serversentevents.demo.observer.impl;

import org.springframework.stereotype.Service;
import org.whipp.serversentevents.demo.observer.Event;
import org.whipp.serversentevents.demo.observer.Observer;
import org.whipp.serversentevents.demo.observer.Subject;

import java.util.List;

public class EventProducer implements Subject {

    private List<Observer<Event>> observers;

    public EventProducer(List<Observer<Event>> observers) {
        this.observers = observers;
    }

    @Override
    public void registerObserver(Observer<Event> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<Event> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Event event) {
        for (Observer<Event> observer : observers) {
            System.out.println("notifying");
            observer.update(event);
        }
    }
}
