package designPatterns.behavioral.observer.interfaces;

public interface Subject {

    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}
