package gameproj.server.netty;

import io.netty.channel.*;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by d.asadullin on 04.02.2015.
 */
@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler {
    private ChannelHandlerContext ctx;
    private AtomicBoolean started=new AtomicBoolean();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg.toString());
        send(msg.toString()+"received");
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }
    public void send(String message) {
        // Do not send more than 4096 numbers.
        ChannelFuture future = null;
        future = ctx.write(message);
       // future.addListener(numberSender);
        ctx.flush();
    }


}
