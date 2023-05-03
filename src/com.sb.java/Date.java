package com.sb.java;

public class Date {

    public int by;
    public String from;

    public Date(int by, String from) {
        this.by = by;
        this.from = from;
    }

    public int getBy() {
        return by;
    }

    public void setBy(int by) {
        this.by = by;
    }

    public String getFrom() {
        return from;
    }

    @Override
    public String toString() {
        return "Date{" +
                "by=" + by +
                ", from='" + from + '\'' +
                '}';
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
