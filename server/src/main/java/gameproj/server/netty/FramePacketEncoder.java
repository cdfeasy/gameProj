package gameproj.server.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: Dmitry
 * Date: 20.10.13
 * Time: 21:05
 * To change this template use File | Settings | File Templates.
 */
public class FramePacketEncoder extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
         byte[] msgBytes;
        try {
            msgBytes=msg.toString().getBytes("utf-8");
        } catch (Exception e) {
            msgBytes=msg.toString().getBytes();
        }
        out.writeInt(msgBytes.length);
        out.writeBytes(msgBytes);
    }
}
