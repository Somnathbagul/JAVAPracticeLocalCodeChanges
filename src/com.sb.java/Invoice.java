package com.sb.java;
import java.util.Date;

public class Invoice {

      private Integer id;
      private Double amount;
      private String number;
      private Date createdOn;

      public Invoice(Integer id, Double amount, String number, Date createdOn) {
              super();
              this.id = id;
              this.amount = amount;
              this.number = number;
              this.createdOn = createdOn;
      }

      public Integer getId() {
              return id;
      }
      public void setId(Integer id) {
             this.id = id;
      }
      public Double getAmount() {
             return amount;
      }
      public void setAmount(Double amount) {
             this.amount = amount;
      }
      public String getNumber() {
             return number;
      }
      public void setNumber(String number) {
             this.number = number;
      }
      public Date getCreatedOn() {
             return createdOn;
      }
      public void setCreatedOn(Date createdOn) {
            this.createdOn = createdOn;
      }

      @Override
      public String toString() {

             return String.format("id = %d, amount = %f, number = %s, createdOn = %s", this.id, this.amount, this.number, this.createdOn.toString());
      }

}
