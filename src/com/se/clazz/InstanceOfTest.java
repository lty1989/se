package com.se.clazz;

import java.io.Serializable;

/**
 * instanceof  A instanceof B
 * 编译通过规则：
 * A的编译时类型和B相同
 * A是B的父类
 * A是B的子类
 */
public class InstanceOfTest {

    public static void main(String[] args) {

        Object hello = "hello";
        System.out.println(hello instanceof Object);

        System.out.println(hello instanceof String);

        System.out.println(hello instanceof Math);

        //String实现了 Comparable
        System.out.println(hello instanceof Comparable);

        String str = "Hello";
        //str编译时类型 是 String  不是 math父类  也不是 math子类,所以编译不通过
        //System.out.println(str instanceof Math);

        System.out.println(str instanceof Serializable);


    }

}
