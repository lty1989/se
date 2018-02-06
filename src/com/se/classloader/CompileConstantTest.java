package com.se.classloader;

/**
 * Created by lty on 2017-11-21.
 */
public class CompileConstantTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println(MyTest.i);

        Class clazz = MyTest.class;
        clazz.newInstance();

    }

}

class MyTest {

    public static int i = 10;
    public final static int j = 10;

    static {
        System.out.println("初始化");
    }


    public MyTest() {
        System.out.println("构造方法");
    }
}
