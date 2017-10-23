package com.se.generic;

/**
 * Created by lty on 2017-10-10.
 */
public class PlateTest {


    public static void main(String[] args) {

        //上界通配符  <? extends T> ?是T的继承类
        Plate<? extends Fruit> plate = new Plate<>(new Apple());

       // plate.set(new Fruit()); set方法失效
        /**
         * get对象只能给 Fruit 或者 Object
         */
        Fruit f = plate.get();
       // Apple a = plate.get();
        Object o = plate.get();

        //下界通配符  <? super T>  T是？的继承类
        Plate<? super Apple> plate1 = new Plate<>(new Apple());
        plate1.set(new Apple());
        plate1.set(new BanaApple());


       Object o1 = plate1.get();//只能给 Object

    }


    // 频繁往外读取内容的，适合用上界Extends。
    // 经常往里插入的，适合用下界Super。


}
