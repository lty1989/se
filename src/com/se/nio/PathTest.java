package com.se.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by lty on 2017-11-21.
 */
public class PathTest {

    public static void main(String[] args) {
        Path path = Paths.get(".");
        System.out.println("路径数量："+path.getNameCount());
        System.out.println("根目录："+path.getRoot());
        System.out.println("根目录："+path.getRoot());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("absolutePath根目录："+absolutePath.getRoot());
        System.out.println("absolutePath路径数量："+absolutePath.getNameCount());
    }
}
