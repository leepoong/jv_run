package com.tencent.lp.protobuf;

import com.tencent.lp.proto.MyProtoClass;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * @author Leepong
 * @date 11:23  2019/11/9
 * @description
 */
public class ProtoClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pp = socketChannel.pipeline();
        pp.addLast(new ProtobufVarint32FrameDecoder());
        pp.addLast(new ProtobufDecoder(MyProtoClass.Person.getDefaultInstance()));
        pp.addLast(new ProtobufVarint32LengthFieldPrepender());
        pp.addLast(new ProtobufEncoder());
        pp.addLast(new ProtoClientHandler());
    }
}
