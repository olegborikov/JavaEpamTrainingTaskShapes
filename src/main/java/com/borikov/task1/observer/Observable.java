package com.borikov.task1.observer;

import java.util.EventObject;

public interface Observable<T extends EventObject> {
    void attach(Observer<T> observer);

    void detach(Observer<T> observer);

    void notifyObservers();
}
