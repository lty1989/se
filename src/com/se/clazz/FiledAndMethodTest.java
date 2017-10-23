package com.se.clazz;

import com.se.util.Utils;

public class FiledAndMethodTest {

    /**
     * 声明时类型  编译时类型
     * <p>
     * 实例变量表现出 声明时类型    方法编译时类型
     *
     * @param args
     */
    public static void main(String[] args) {

        Base b = new Base();
        b.display();

        Utils.Line();

        Derived d = new Derived();
        System.out.println(d.count);
        d.display();

        Utils.Line();
        Base bd = new Derived();
        System.out.println(bd.count);
        bd.display();


        Utils.Line();
        Base bd2 = d;
        System.out.println(bd2.count);
        bd2.display();


    }


}
