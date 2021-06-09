package com.pwh.netty.c1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestScatterRead {
    public static void main(String[] args) {
        try (FileChannel channel = new RandomAccessFile("src/words.txt","r").getChannel()) {
            final ByteBuffer buffer1 = ByteBuffer.allocate(3);
            final ByteBuffer buffer2 = ByteBuffer.allocate(3);
            final ByteBuffer buffer3 = ByteBuffer.allocate(5);
            channel.read(new ByteBuffer[]{buffer1,buffer2,buffer3});
            buffer1.flip();
            buffer2.flip();
            buffer3.flip();
            ByteBufferUtil.debugAll(buffer1);
            ByteBufferUtil.debugAll(buffer2);
            ByteBufferUtil.debugAll(buffer3);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
