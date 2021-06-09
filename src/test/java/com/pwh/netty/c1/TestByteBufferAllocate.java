package com.pwh.netty.c1;

import java.nio.ByteBuffer;

public class TestByteBufferAllocate {
    public static void main(String[] args) {
        System.out.println(ByteBuffer.allocate(10).getClass());
        System.out.println(ByteBuffer.allocateDirect(10).getClass());
        /*
        * class java.nio.HeapByteBuffer  -java堆内存，读写效率低，受GC的影响
          class java.nio.DirectByteBuffer  -直接内存，分配效率低
* */
    }
}
