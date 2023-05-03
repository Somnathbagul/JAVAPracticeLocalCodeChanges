package com.sb.java;

public class Singleton {
    // private constructor to prevent instantiation from outside
    private Singleton() {}
    
    // static variable to hold the single instance of the class
    private static Singleton instance = null;
    
    // static method to create and return the single instance of the class
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    // other methods and properties of the class...
}
