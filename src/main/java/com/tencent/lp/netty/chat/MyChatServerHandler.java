package com.tencent.lp.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import javax.sound.midi.Soundbank;

/**
 * @author Leepong
 * @date 12:15  2019/11/5
 * @description
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {
    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
        Channel channel = ctx.channel();
        channels.forEach(ch -> {
            if (ch != channel) {
                System.out.println(msg);
                ch.writeAndFlush(channel.remoteAddress() + " 发送的消息: " + msg);
            } else {
                ch.writeAndFlush("自己发送的消息: " + msg);
            }
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        String msg = "客户端: " + ctx.channel().remoteAddress() + " 上线了\n";
        channels.writeAndFlush(msg);
        System.out.println(msg);
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        String msg = "客户端: " + ctx.channel().remoteAddress() + " 下线了\n";
        channels.writeAndFlush(msg);
        System.out.println(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
