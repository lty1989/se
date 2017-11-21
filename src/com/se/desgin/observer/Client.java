package com.se.desgin.observer;

/**
 * Created by lty on 2017-11-6.
 */
public class Client {

    public static void main(String[] args) {

        AbstractSubject ad = new ConcreteSubject();


        Observer o1 = new ConcreteObserver();
        Observer o2 = new ConcreteObserver();
        Observer o3 = new ConcreteObserver();
        Observer o4 = new ConcreteObserver();
        Observer o5 = new ConcreteObserver();

        ad.attach(o1);
        ad.attach(o2);
        ad.attach(o3);
        ad.attach(o4);
        ad.attach(o5);

        ad.notify("123");


    }

}
