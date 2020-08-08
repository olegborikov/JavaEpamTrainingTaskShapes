package com.borikov.task1.util;

public class IdGenerator {
    private static final long MIN_ID = 1;
    private static final long MAX_ID = 100_000;
    private static long counter = 0;

    private IdGenerator() {
    }

    public static long generateId() {
        if (counter + 1 > MAX_ID) {
            counter = MIN_ID;
        } else {
            counter++;
        }
        return counter;
    }
}
