package com.tencent.lp.netty.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @author Leepong
 * @date 9:47  2019/11/4
 * @description
 */
public class TestServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        ByteBuf buf = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);
        FullHttpResponse rsp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, buf);
        rsp.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
        rsp.headers().set(HttpHeaderNames.CONTENT_LENGTH, buf.readableBytes());

        ctx.writeAndFlush(rsp);
//        ctx.channel().closeFuture();
    }
}
