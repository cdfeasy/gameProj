package gameproj.server.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dmitry
 * Date: 20.10.13
 * Time: 20:54
 * To change this template use File | Settings | File Templates.
 */
public class FramePacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf buffer, List<Object> list) throws Exception {
        if(buffer.readableBytes() < 4){
            return;
        }
        int length = buffer.getInt(buffer.readerIndex());
        if(buffer.readableBytes() < length + 4){
            buffer.resetReaderIndex();
            return;
        }
        buffer.skipBytes(4);
        list.add(new String(buffer.readBytes(length).array()));
    }
}
