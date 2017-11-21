package com.se.nio;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by lty on 2017-11-21.
 */
public class FileChannelTest {

    public static void main(String[] args) {
        File f = new File("D:\\deaProjects\\se\\src\\com\\se\\nio\\FileChannelTest.java");
        try {
            FileChannel inChannel = new FileInputStream(f).getChannel();
            FileChannel outChannel = new FileOutputStream("a.txt").getChannel();

            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY,0, f.length());
            Charset charset = Charset.forName("GBK");
            outChannel.write(buffer);
            buffer.clear();
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
