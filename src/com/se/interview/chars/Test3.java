package com.se.interview.chars;

/**
 * 翻转句子中单词的顺序，但单词内字符的顺序不变，句子中单词以空格符隔开。例如I am a original string翻转后的结果为string original a am I。
 * Created by lty on 2018-1-30.
 */
public class Test3 {
    static void reverseSub(char p[], int start, int end) {
        char c;
        int i = start;
        int j = end;
        while (i < j) {
            c = p[i];
            p[i] = p[j];
            p[j] = c;
            i++;
            j--;
        }
    }

    static void reverseSentence(char p[], int length) {
        //首先翻转整个具体的所有字符。
        reverseSub(p, 0, length - 1);
        int pStart = 0;
        int pEnd = 0;
        //从头开始遍历，寻找句子中的单词，pStart和pEnd分别表示单词的起止下标。
        while (pStart < length && pEnd < length) {
            if (p[pStart] == ' ') {
                pStart++;
                pEnd++;
            } else if (p[pEnd] == ' ' || p[pEnd] == '\0') {
                //翻转单词中的字符。
                reverseSub(p, pStart, --pEnd);
                pStart = ++pEnd;
            } else {
                pEnd++;
            }
        }
    }


    public static void main(String[] args) {
        char[] source = "I am a original string".toCharArray();
        System.out.println(source);
        reverseSentence(source, source.length);
        System.out.println(source);


    }

}
