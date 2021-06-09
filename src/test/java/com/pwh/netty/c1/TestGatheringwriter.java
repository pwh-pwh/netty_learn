package com.pwh.netty.c1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class TestGatheringwriter {
    public static void main(String[] args) {


        final ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello");
        final ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("world");
        final ByteBuffer buffer3 = StandardCharsets.UTF_8.encode("你好");
        try (FileChannel channel = new RandomAccessFile("words2.txt", "rw").getChannel()) {
            channel.write(new ByteBuffer[]{buffer1,buffer2,buffer3});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
