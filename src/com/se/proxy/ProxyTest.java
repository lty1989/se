package com.se.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.Period;
import java.util.HashMap;

interface Preson {
    void walk();

    void sayHello(String str);
}


class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("正在执行的方法-->" + method);
        if (args != null) {
            System.out.println("传入参数为--->");
            for (Object o : args) {
                System.out.println(o);
            }
        } else {
            System.out.println("没有参数");
        }




        return null;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        InvocationHandler invocationHandler = new MyInvocationHandler();
        Preson p = (Preson) Proxy.newProxyInstance(Preson.class.getClassLoader(), new Class[]{Preson.class}, invocationHandler);
        p.walk();
        p.sayHello("123");
    }
}
