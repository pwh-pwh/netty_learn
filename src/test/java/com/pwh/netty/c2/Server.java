package com.pwh.netty.c2;

import com.pwh.netty.c1.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class Server {
    public static void main(String[] args) {
//        ByteBuffer
        final ByteBuffer buffer = ByteBuffer.allocate(32);
//        创建服务器
        try (ServerSocketChannel ssr = ServerSocketChannel.open()) {
//            监听端口
            ssr.bind(new InetSocketAddress(8080));
            List<SocketChannel> channelList = new ArrayList<>();
            while(true) {
                log.debug("connecting");
//                握手
                final SocketChannel channel = ssr.accept();//阻塞方法,知道有新的连接
                log.debug("connected..{}",channel);
                channelList.add(channel);
                channelList.forEach(cn->{
                    try {
                        log.debug("before read..{}",cn);
                        cn.read(buffer);//阻塞方法
                        buffer.flip();
                        ByteBufferUtil.debugRead(buffer);
                        buffer.clear();
                        log.debug("after read");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
