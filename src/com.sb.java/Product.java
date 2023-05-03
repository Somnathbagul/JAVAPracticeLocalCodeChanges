package com.sb.java;

public class Product {

    private Price price;
    private String sellerName;
    private String origCondition;
    private OrigDelivery origDelivery;

    public Product(Price price, String sellerName, String origCondition, OrigDelivery origDelivery) {
        this.price = price;
        this.sellerName = sellerName;
        this.origCondition = origCondition;
        this.origDelivery = origDelivery;
    }


    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getOrigCondition() {
        return origCondition;
    }

    public void setOrigCondition(String origCondition) {
        this.origCondition = origCondition;
    }

    public OrigDelivery getOrigDelivery() {
        return origDelivery;
    }

    public void setOrigDelivery(OrigDelivery origDelivery) {
        this.origDelivery = origDelivery;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", sellerName='" + sellerName + '\'' +
                ", origCondition='" + origCondition + '\'' +
                ", origDelivery=" + origDelivery +
                '}';
    }

    public int getDeliveryTime() {
        String[] parts = this.getOrigDelivery().getDate().getFrom().split(" ");
        int day = Integer.parseInt(parts[1]);
        return this.getOrigDelivery().getDate().getBy() - day;
    }
}
