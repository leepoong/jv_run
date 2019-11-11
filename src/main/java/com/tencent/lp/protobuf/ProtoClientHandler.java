package com.tencent.lp.protobuf;

import com.tencent.lp.proto.MyProtoClass;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Leepong
 * @date 11:24  2019/11/9
 * @description
 */
public class ProtoClientHandler extends SimpleChannelInboundHandler<MyProtoClass.Person> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyProtoClass.Person msg) throws Exception {
        System.out.println(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyProtoClass.Person person = MyProtoClass.Person.newBuilder()
                .setName("sanshang")
                .setAge(23)
                .setGender(MyProtoClass.Gender.FEMALE)
                .build();
        ctx.writeAndFlush(person);
    }
}
