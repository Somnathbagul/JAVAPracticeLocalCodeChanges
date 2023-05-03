package com.sb.java;

public class JavaBasicConcepts {
    static class MyThread extends Thread {
        public void run() {
            // code to be executed in this thread
            System.out.println("Thred extends by Thread class");
        }
    }

   static class MyRunnable implements Runnable {
        public void run() {
            // code to be executed in this thread
            System.out.println("Thred implements by Runnable interface");
        }
    }

    public static void main(String[] args) {
        System.out.println("Learning Thread...");
        MyThread t1 = new MyThread();
        t1.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        System.out.println("Learning Thread ended here...");



    }
}
