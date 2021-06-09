package com.pwh.netty.c1;

import java.nio.ByteBuffer;

public class TestBufferExam {
    public static void main(String[] args) {
        final ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm zhangsan\nho".getBytes());
        split(source);
        source.put("w are you?\n".getBytes());
        split(source);
    }
    public static void split(ByteBuffer buffer){
        buffer.flip();
        for (int i = 0; i < buffer.limit(); i++) {

            if ('\n'==buffer.get(i)) {
                int length = i+1-buffer.position();
                final ByteBuffer target = ByteBuffer.allocate(length);
                for (int j = 0; j < length; j++) {
                    target.put(buffer.get());
                }
                ByteBufferUtil.debugAll(target);
            }


        }

        buffer.compact();
    }
}
