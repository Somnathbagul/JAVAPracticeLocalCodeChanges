package com.sb.java;

class Counter {
    private int count = 0;
    public synchronized void increment() {
        count++;
        System.out.println("counter "+ count);
    }
    public synchronized int getCount() {
        return count;
    }
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                c.increment();
                System.out.println("T1 Thread");
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                c.increment();
                System.out.println("T2 Thread");
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.getCount());
    }
}