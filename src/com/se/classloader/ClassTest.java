package com.se.classloader;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


@interface Anno {

}

@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Annos {
    Anno[] values();
}

@SuppressWarnings(value = "unchecked")
@Deprecated
@Anno
public class ClassTest {

    private ClassTest() {
        System.out.println("无参构造方法");
    }

    public ClassTest(String name) {
        System.out.println("有参构造方法");
    }


    public void info() {
        System.out.println("无参info方法");
    }

    public void info(String s) {
        System.out.println("有参info方法");
    }


    class Inner {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<ClassTest> clazz = ClassTest.class;
        Constructor[] ctors = clazz.getDeclaredConstructors();
        System.out.println("全部构造方法");
        for (Constructor c : ctors) {
            System.out.println(c);
        }
        Constructor[] publicCtors = clazz.getConstructors();
        System.out.println("全部public构造方法");
        for (Constructor c : publicCtors) {
            System.out.println(c);
        }
        Method[] mtds = clazz.getMethods();
        System.out.println("全部public方法");
        for (Method m : mtds) {
            System.out.println(m);
        }
        System.out.println("一个带String参数的info:" + clazz.getMethod("info", String.class));
        Class<?>[] inners = clazz.getDeclaredClasses();
        System.out.println("全部内部类");
        for (Class c : inners) {
            System.out.println(c);
        }


    }
}
