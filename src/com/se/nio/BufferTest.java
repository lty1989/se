package com.se.nio;

import java.nio.Buffer;
import java.nio.CharBuffer;

/**
 * Created by lty on 2017-11-21.
 */
public class BufferTest {

    public static void main(String[] args) {

        CharBuffer buffer = CharBuffer.allocate(8);
        printPa(buffer);
        buffer.put('a');
        buffer.put('b');
        buffer.put('c');
        printPa(buffer);
        buffer.flip();
        printPa(buffer);
        buffer.get(2);
        printPa(buffer);
    }

    private static void printPa(Buffer buffer) {
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("position:" + buffer.position());
        System.out.println("limit:" + buffer.limit());
        System.out.println("****************************:");

    }

}
