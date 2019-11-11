package com.tencent.lp.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Leepong
 * @date 12:32  2019/11/5
 * @description
 */
public class MyChatClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker)
                    .channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitializer());
            ChannelFuture future = bootstrap.connect("localhost", 12305).sync();
            Channel channel = future.channel();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (; ; ) {
                String msg = reader.readLine();
                channel.writeAndFlush(msg + "\r\n");
            }
        } finally {
            worker.shutdownGracefully();
        }
    }

}
