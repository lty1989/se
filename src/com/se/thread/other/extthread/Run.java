package com.se.thread.other.extthread;

public class Run {

    public static void main(String[] args) {

        MyThread[] mt = new MyThread[100];

        for (int i = 0; i < 100; i++) {
            mt[i] = new MyThread();
        }

        for (int i = 0; i < 100; i++) {
            mt[i].start();
        }


    }

}
