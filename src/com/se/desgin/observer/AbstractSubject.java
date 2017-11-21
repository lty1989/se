package com.se.desgin.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 * Created by lty on 2017-11-6.
 */
public class AbstractSubject {

    /**
     * 保存观察者集合
     */
    private List<Observer> list = new ArrayList<>();

    public void attach(Observer observer) {
        list.add(observer);
    }

    public void detach(Observer observer) {
        list.remove(observer);
    }

    public void notify(String content) {
        for (Observer o : list) {
            o.update(content);
        }
    }


}
