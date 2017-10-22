package com.se.thread.practise;

public class PrintDemo {


    public static void main(String[] args) {
        Print print = new Print();
        new PrintThread("A", print).start();
        new PrintThread("B", print).start();
        new PrintThread("C", print).start();
    }

}

class Print {
    private String next = "A";

    public synchronized void print(String content) {
        while (!next.equals(content)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (next.equals(content)) {
            System.out.println(content);
            if (content.equals("C")) {
                System.out.println();
            }
            if (content.equals("A")) {
                next = "B";
            } else if (content.equals("B")) {
                next = "C";
            } else if (content.equals("C")) {
                next = "A";
            }
            notifyAll();
        }
    }


}

class PrintThread extends Thread {

    Print print = null;

    public PrintThread(String name, Print print) {
        super(name);
        this.print = print;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            print.print(getName());
        }
    }
}
