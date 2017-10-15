package com.se.thread.other.extthread;

public class MyThread extends Thread {

    public static volatile int count;

    private void addCount() {

        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" + count);

    }

    @Override
    public void run() {
        addCount();
    }
}
