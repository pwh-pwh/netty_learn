package com.pwh.netty.c1;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class TestFilesCopy {
    public static void main(String[] args) throws Exception {
        copyFunOne("/root/下载/web_bookstore-master","/root/下载/temp");

    }
    public static void copyFunTwo(String source,String target) throws IOException {
        Files.walkFileTree(Paths.get(source),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                String targetDirName = dir.toString().replace(source,target);
                Files.createDirectory(Paths.get(targetDirName));
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String targetFileName = file.toString().replace(source,target);
                Files.copy(file,Paths.get(targetFileName));
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return super.visitFileFailed(file, exc);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return super.postVisitDirectory(dir, exc);
            }
        });
    }
    public static void copyFunOne(String source,String target) throws Exception {

        Files.walk(Paths.get(source)).forEach(path -> {
            final String targetName = path.toString().replace(source, target);
            if (Files.isDirectory(path)) {
                try {
                    Files.createDirectory(Paths.get(targetName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    Files.copy(path,Paths.get(targetName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
