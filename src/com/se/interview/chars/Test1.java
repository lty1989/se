package com.se.interview.chars;

/**
 * 实现一个函数，将字符串p中的所有空格都替换成为指定的字符串r。
 * Created by lty on 2018-1-30.
 */
public class Test1 {
    public static void main(String[] args) {
        String p = "1 22  333 444";
        String r = "AA";
        String newStr = toChange(p, r);
        System.out.println(newStr);
    }


    public static String toChange(String str, String replace) {

        char[] strChar = str.toCharArray();
        char[] replaceChar = replace.toCharArray();

        int strLen = strChar.length;
        int replaceLen = replaceChar.length;

        int lenBlack = 0;
        for (int i = 0; i < strLen; i++) {
            if (' ' == strChar[i]) {
                lenBlack++;
            }
        }


        int totalLen = strLen + lenBlack * replaceLen;
        char[] newChars = new char[totalLen];

        for (int i = 0, j = 0; i < strLen; i++) {
            if (' ' == strChar[i]) {
                for (int k = 0; k < replaceLen; k++) {
                    newChars[j++] = replaceChar[k];
                }
            } else {
                newChars[j++] = strChar[i];
            }
        }
        return new String(newChars);
    }

}
