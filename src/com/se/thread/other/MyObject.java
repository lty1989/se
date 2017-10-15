package com.se.thread.other;

public class MyObject {

    public synchronized void mehodA() {

        try {
            System.out.println("begin mehodA name:" + Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("mehodA end time " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void mehodB() {

        try {
            System.out.println("begin mehodB name:" + Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("mehodB end time " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
