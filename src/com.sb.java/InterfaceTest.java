package com.sb.java;
public class InterfaceTest {
    interface A  { void present(); }
    interface B { void present(); }

    interface Presentable extends A, B { }

    public static void main(String[] args) {
        
    	Presentable presentable = new Presentable() {
            @Override public void present() {
                System.out.println("Heeeereee's Johnny!!!");
            }
        };
        
        presentable.present();                     // "Heeeereee's Johnny!!!"

        ((A) presentable).present();            // "Heeeereee's Johnny!!!"
        ((B) presentable).present();           // "Heeeereee's Johnny!!!"

        A johnnyAsGift = (A) presentable;
        johnnyAsGift.present();               // "Heeeereee's Johnny!!!"

        B johnnyAsGuest = (B) presentable;
        johnnyAsGuest.present();              // "Heeeereee's Johnny!!!"
    }
}