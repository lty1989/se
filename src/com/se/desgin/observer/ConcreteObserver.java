package com.se.desgin.observer;

/**
 * Created by lty on 2017-11-6.
 */
public class ConcreteObserver implements Observer {


    @Override
    public void update(String content) {
        System.out.println("contetn:" + content);

    }
}

