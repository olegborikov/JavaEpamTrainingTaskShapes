package com.borikov.task1.observer;

public interface Observable {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObserver();
}
