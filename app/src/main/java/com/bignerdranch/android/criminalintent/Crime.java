package com.bignerdranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {

    private final UUID id;
    private String title;
    private Date date;
    private boolean isSolved;

    private Crime() {
        this.id = UUID.randomUUID();
        this.title = "";
        this.date = new Date();
        this.isSolved = false;
    }

    private static class LazyHolder {
        public static Crime INSTANCE = new Crime();
    }

    public static Crime getInstance() { return LazyHolder.INSTANCE; }

}
