package com.se.clazz;

import java.io.Serializable;

/**
 * instanceof  A instanceof B
 * 编译通过规则：
 * A的编译时类型和B相同
 * A是B的父类
 * A是B的子类
 */
public class InstanceOfTest2 {

    public static void main(String[] args) {

        Object hello = "hello";
        Math math = (Math) hello;
        System.out.println(math instanceof Math);


    }

}
