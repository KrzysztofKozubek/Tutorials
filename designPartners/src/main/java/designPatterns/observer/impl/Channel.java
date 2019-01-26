package designPatterns.observer.impl;

import designPatterns.observer.interfaces.Observer;
import designPatterns.observer.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {

    private List<Observer> observers;

    public Channel() {
        observers = new ArrayList<>();
    }

    public void publishNewVideo() {
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
