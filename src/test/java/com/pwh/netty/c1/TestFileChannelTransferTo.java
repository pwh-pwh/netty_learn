package com.pwh.netty.c1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TestFileChannelTransferTo {
    public static void main(String[] args) {
        try (
                FileChannel from = new FileInputStream("src/data.txt").getChannel();
                final FileChannel to = new FileOutputStream("src/out.txt").getChannel()
        ) {
            System.out.println(from.position());
//            效率高，底层会利用操作系统的零拷贝进行优化,一次`最多2g
            long size = from.size();
//            left剩下字节
            for(long left = size;left>0;){
                left-=from.transferTo((size-left),left,to);
            }
        } catch (IOException e) {
        }
    }
}
