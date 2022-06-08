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

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }
}
