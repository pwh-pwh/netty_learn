package com.pwh.netty.c1;

import checkers.units.quals.A;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

public class TestFilesWalkFileTree {

    public static void main(String[] args) throws IOException {
        getJarNum();
    }
    public static void getCountDirAndFile() throws IOException {
        AtomicInteger dirCount = new AtomicInteger();
        AtomicInteger fileCount = new AtomicInteger();
        Files.walkFileTree(Paths.get("/opt/jdk1.8.0_171/"), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                dirCount.incrementAndGet();
                System.out.println(dir);

                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                fileCount.incrementAndGet();
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return super.visitFileFailed(file, exc);
            }
        });
        System.out.println("dirCount : "+dirCount);
        System.out.println("fileCount : "+fileCount);
    }
    public static void getJarNum() throws IOException {
        AtomicInteger count = new AtomicInteger();
        Files.walkFileTree(Paths.get("/opt/jdk1.8.0_171/"),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().endsWith(".jar")) {
                    System.out.println(file.getFileName());
                    count.incrementAndGet();
                }
                return super.visitFile(file, attrs);
            }
        });
        System.out.println("the number of jar is "+count);
    }
}
