package com.se.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by lty on 2017-11-21.
 */
public class FilesTest {

    public static void main(String[] args) {

        try {
            Files.copy(Paths.get("FilesTest.java"),new FileOutputStream("b.txt"));
            Files.isHidden(Paths.get("FilesTest.java"));
            List<String> lines = Files.readAllLines(Paths.get("FilesTest.java"), Charset.forName("GBK"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
