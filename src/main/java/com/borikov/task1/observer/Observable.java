package com.borikov.task1.observer;

import java.util.EventObject;

public interface Observable<T extends Observer<? extends EventObject>> {
    void attach(T t);

    void detach(T t);

    void notifyObservers();
}
