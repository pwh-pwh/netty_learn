package com.pwh.netty.c1;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        /*
        * FileChannel
        * 1.输入输出流 2.RandomAccessFile
        * */
        try (FileChannel channel = new FileInputStream("src/data.txt").getChannel()) {
            //建立缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while(true){
//                读入缓冲区
                final int len = channel.read(buffer);
                log.debug("取到的字节为{}",len);
                if(len==-1){
                    break;
                }
                /*
                * 翻转这个缓冲区。 将限制设置为当前位置，然后将位置设置为零。
                *  如果定义了标记，则将其丢弃。
                 在一系列通道读取或放置操作之后，调用此方法以准备一系列通道写入或相关获取操作*/
                buffer.flip();
                while(buffer.hasRemaining()){
                    final byte b = buffer.get();
//                    System.out.println((char)b);
                    log.debug("读取的字节为{}",(char)b);
                }
                /*清除此缓冲区。 将位置设置为零，将限制设置为容量，并丢弃标记。
               在使用通道读取或放置操作序列填充此缓冲区之前调用此方法*/
                buffer.clear();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
