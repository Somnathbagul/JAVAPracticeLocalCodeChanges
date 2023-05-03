package com.sb.java;

public class OrigDelivery {
    public Date date;

    public Date getDate() {
        return date;
    }

    public OrigDelivery(Date date) {
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrigDelivery{" +
                "date=" + date +
                '}';
    }
}