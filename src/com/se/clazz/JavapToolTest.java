package com.se.clazz;

public class JavapToolTest {

    int count = 20;

    {
        count = 12;

    }

    public JavapToolTest() {

    }

    @Override
    public String toString() {
        return "count:" + count;
    }

    public static void main(String[] args) {
        JavapToolTest tool = new JavapToolTest();
        System.out.println(tool);
    }
}
