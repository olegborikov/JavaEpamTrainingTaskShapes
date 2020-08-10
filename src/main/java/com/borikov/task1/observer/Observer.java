package com.borikov.task1.observer;

import java.util.EventObject;

public interface Observer<T extends EventObject> {
    void actionPerformed(T t);
}
