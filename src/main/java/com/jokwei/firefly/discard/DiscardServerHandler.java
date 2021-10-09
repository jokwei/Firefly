package com.jokwei.firefly.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a server-side channel
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // Discard the received data silently
        ByteBuf in = (ByteBuf)msg;
        try {
            while (in.isReadable()) {
//                System.out.print((char)in.readByte());
//                System.out.flush();

                // 该方法输出的是满屏输入首字母
//                System.out.print(in.toString(CharsetUtil.US_ASCII));


            }
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
