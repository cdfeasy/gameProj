package gameproj.server.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LoggingHandler;

/**
 * Created with IntelliJ IDEA.
 * User: dmitry
 * Date: 23.12.12
 * Time: 18:59
 * To change this template use File | Settings | File Templates.
 */
public class Server implements Runnable{
    EventLoopGroup bossGroup;
    EventLoopGroup workerGroup;
    public void run()  {
        // Configure the zombies.entity.server.
        bossGroup = new NioEventLoopGroup(); // (1)
        workerGroup = new NioEventLoopGroup(4);
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new FramePacketDecoder(), new FramePacketEncoder(), new ServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture f = null; // (7)
            f = bootstrap.bind(19999).sync();
            f.channel().closeFuture().sync();
        }catch (InterruptedException e) {
                e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
        ObjectEncoder encoder;
        ObjectDecoder decoder;
        LoggingHandler handler;

    }
    public void stop(){
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        Server server=new Server();
        new Thread(server).start();
        System.out.println("started");
        Thread.sleep(100000);
        server.stop();
        System.out.println("ended");
    }
}
