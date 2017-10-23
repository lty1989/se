package com.se.exception;

/**
 * Created by lty on 2017-10-23.
 */
public class FinallyFlowTest {

    public static String test() {
        String str = "";
        try {
            str = "1111";
            return str;

        } finally {
            str = "2222";
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println(FinallyFlowTest.test());

    }

}
