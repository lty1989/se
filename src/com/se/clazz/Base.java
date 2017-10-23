package com.se.clazz;

/**
 * Created by lty on 2017-10-19.
 */
class Base {

    int count = 2;

    public void display() {
        System.out.println(this.count);
    }

}

class Derived extends  Base{

    int count = 20;

    final public void display() {
        System.out.println(this.count);
    }



}

