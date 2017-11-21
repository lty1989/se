package com.se.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by lty on 2017-11-21.
 */
public class ReadTest {

    public static void main(String[] args) {


        try {
            FileInputStream inputStream = new FileInputStream("a.txt");
            FileChannel channel = inputStream.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(256);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                Charset charset = Charset.forName("GBK");
                CharsetDecoder decoder = charset.newDecoder();
                CharBuffer charBuffer = decoder.decode(buffer);
                System.out.println(charBuffer);
                buffer.clear();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
