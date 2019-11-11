package com.tencent.lp.netty.socket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import javax.sound.midi.Soundbank;

/**
 * @author Leepong
 * @date 21:07  2019/11/4
 * @description
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
        ctx.writeAndFlush("from server " + msg);
    }
}
