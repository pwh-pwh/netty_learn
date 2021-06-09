package com.pwh.netty.c1;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static com.pwh.netty.c1.ByteBufferUtil.debugAll;
public class ByteBufferString {
    public static void main(String[] args) {
        final ByteBuffer buffer0 = ByteBuffer.allocate(10);
        buffer0.put("hello".getBytes());
        ByteBufferUtil.debugAll(buffer0);

        final ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello");
        ByteBufferUtil.debugAll(buffer1);

        final ByteBuffer buffer2 = ByteBuffer.wrap("hello".getBytes());
        debugAll(buffer2);

        System.out.println(StandardCharsets.UTF_8.decode(buffer1).toString());



    }
}
