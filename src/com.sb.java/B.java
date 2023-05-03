package com.sb.java;

class B extends A{
        public void print(){
         System.out.println("Class B");
        }
        public void printAgain(){
            System.out.println("Class B printAgain");
        }

    public static void main(String[] args) {
        A a = new B();
        a.print();

    }
    }