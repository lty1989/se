package com.se.thread.other;

public class Run {

    public static void main(String[] args) {

        MyObject object = new MyObject();
        new ThreadA(object).start();
        new ThreadB(object).start();


    }
}

class ThreadA extends Thread {

    private MyObject object = null;

    public ThreadA(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.mehodA();
    }
}


class ThreadB extends Thread {

    private MyObject object = null;

    public ThreadB(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.mehodB();
    }
}
