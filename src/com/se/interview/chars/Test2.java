package com.se.interview.chars;

/**
 * 在字符串中找出第一个只出现一次的字符。如输入abaccdeff，则输出b，要求时间复杂度为O(n)。
 * Created by lty on 2018-1-30.
 */
public class Test2 {
    static char firstNotRepeat(char p[], int len) {
        if (len == 1)
            return p[0];
        int c[] = new int[256];
        int i;
        char r = p[0];
        for (i = 0; i < 256; i++)
            c[i] = 0;
        for (i = 0; i < len; i++) {
            System.out.println(p[i] + "," + c[p[i]]);
            c[p[i]] += 1;
        }
        for (i = 0; i < len; i++) {
            if (c[p[i]] == 1) {
                r = p[i];
                break;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        char[] source = "abaccdeff".toCharArray();
        char c = firstNotRepeat(source, source.length);
        System.out.println(c);
    }


}
