package com.sb.java;

class DeadlockDemo implements Runnable{
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            synchronized (lock2) {
                // code to be executed
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            synchronized (lock1) {
                // code to be executed
            }
        }
    }

    @Override
    public void run() {
       System.out.println("Calling again..");
    }



    public static void main(String[] args) {
        DeadlockDemo demo = new DeadlockDemo();
        Thread t1 = new Thread(() -> demo.method1());
        Thread t2 = new Thread(() -> demo.method2());
        t1.start();
        t2.start();

    }


}
