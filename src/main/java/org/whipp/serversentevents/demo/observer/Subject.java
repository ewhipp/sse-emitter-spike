package org.whipp.serversentevents.demo.observer;

public interface Subject {
    public void registerObserver(Observer<Event> observer);
    public void removeObserver(Observer<Event> observer);
    public void notifyObservers(Event event);
}
