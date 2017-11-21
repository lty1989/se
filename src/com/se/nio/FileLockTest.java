package com.se.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by lty on 2017-11-21.
 */
public class FileLockTest {

    public static void main(String[] args) {

        try {
            FileChannel channel = new FileInputStream("a.txt").getChannel();
            FileLock lock =channel.tryLock();
            lock.release();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
