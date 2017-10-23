package com.se.clazz;

/**
 * Created by lty on 2017-10-23.
 * 非静态内部类必须寄生在外部类实例中
 */
public class Outer {

    private void test() throws IllegalAccessException, InstantiationException {
        //this作为参数传入Inner构建
        new Inner();
        Inner.class.newInstance();
    }

    /**
     * 没有无惨构造函数 构造器需要一个 Outer作为参数
     */
    public class Inner {
        //非静态内部类不能声明静态属性
        // static String str = "123";

        public Inner() {
            System.out.println("无惨构造器");
        }

        public Inner(String name) {
            System.out.println("有参数惨构造器");
        }

        @Override
        public String toString() {
            return "Inner对象";
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        new Outer().test();

    }

}
