package com.pwh.netty.c2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        final SocketChannel client = SocketChannel.open();
        client.connect(new InetSocketAddress("localhost",8080));
        System.out.println("wait...");
    }
}
