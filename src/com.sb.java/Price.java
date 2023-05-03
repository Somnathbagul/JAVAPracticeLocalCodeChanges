package com.sb.java;

public class Price {
    public Double value;
    public String currencyId;

    public Price(Double value, String currencyId) {
        this.value = value;
        this.currencyId = currencyId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", currencyId='" + currencyId + '\'' +
                '}';
    }


}
