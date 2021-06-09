package com.pwh.netty.c1;

import java.nio.ByteBuffer;

public class TestByteBufferRead {
    public static void main(String[] args) {
        final ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});
        buffer.flip();
//        System.out.println(buffer.get(new byte[4]));
//        System.out.println(buffer.get(new byte[2]));
//        System.out.println((char)buffer.get());
        buffer.rewind(); //position=0
        buffer.get();
        buffer.get();
        buffer.mark(); //标记
        System.out.println((char)buffer.get());
        buffer.reset(); //position=mark
        System.out.println((char)buffer.get());


    }
}
