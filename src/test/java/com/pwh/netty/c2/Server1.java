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
public class Server1 {
    public static void main(String[] args) {
//        ByteBuffer
        final ByteBuffer buffer = ByteBuffer.allocate(32);
//        创建服务器
        try (ServerSocketChannel ssr = ServerSocketChannel.open()) {
            ssr.configureBlocking(false);//非阻塞,影响accept方法，没有连接,返回null
//            监听端口
            ssr.bind(new InetSocketAddress(8080));
            List<SocketChannel> channelList = new ArrayList<>();
            while(true) {
                log.debug("connecting");
//                握手
                final SocketChannel channel = ssr.accept();
                if (channel!=null) {
                    channelList.add(channel);
                    channel.configureBlocking(false);//非阻塞,read读取空值
                    log.debug("connected..{}",channel);

                }
                channelList.forEach(cn->{
                    try {
                        log.debug("before read..{}",cn);
                        cn.read(buffer);//
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
