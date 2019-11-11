package com.tencent.lp.protobuf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author Leepong
 * @date 11:19  2019/11/9
 * @description
 */
public class ProtoClient {
    public static void main(String[] args) {
        String cloudIp = "111.231.115.156";
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(work)
                    .channel(NioSocketChannel.class)
                    .handler(new ProtoClientInitializer());
            ChannelFuture future = bootstrap.connect(new InetSocketAddress(cloudIp, 12305)).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
