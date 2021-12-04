package com.mikola.shape.util;

public class IdGenerator {
    private static long id;

    public static long generateId() {
        return id++;
    }

}
