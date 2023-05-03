package com.sb.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Customer {

    String name;
    int age;


    Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int hashCode() {
        int result = 17; // a prime number
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Customer)) return false;
        Customer other = (Customer) obj;
        return this.age == other.age && this.name.equals(other.name);
    }

    public static void main(String[] args) {

        Customer c1 = new Customer("John", 20);
        Customer c2 = new Customer("John", 20);

        HashSet<Customer> customerSet = new HashSet<>();
        customerSet.add(c1);
        customerSet.add(c2);
        System.out.println(customerSet.size());

        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");

        for(int i =1; i< names.size(); i++){
            System.out.println(names.get(i));
            names.remove(i);
        }

    }
}