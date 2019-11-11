package com.tencent.lp.protobuf;

import com.tencent.lp.proto.MyProtoClass;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Leepong
 * @date 11:17  2019/11/9
 * @description
 */
public class ProtoServerHandler extends SimpleChannelInboundHandler<MyProtoClass.Person> {

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " 连接了");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " 断开了");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " in active");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyProtoClass.Person msg) throws Exception {
        String name = msg.getName();
        System.out.println("name from client : " + name);
    }
}
