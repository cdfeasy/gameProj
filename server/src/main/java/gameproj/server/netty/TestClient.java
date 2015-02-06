package gameproj.server.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Created by d.asadullin on 04.02.2015.
 */
public class TestClient implements Runnable {


    EventLoopGroup bossGroup;
    private TestClientHandler handler;
    public TestClient(TestClientHandler handler){
       this.handler=handler;
    }

    public void run() {
        // Configure the zombies.entity.server.
        bossGroup = new NioEventLoopGroup(); // (1)
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(bossGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() { // (4)
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new FramePacketDecoder(),  new FramePacketEncoder(), handler);
                        }
                    });
            try {
                bootstrap.connect("localhost", 19999).sync().channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            bossGroup.shutdownGracefully();
        }

    }
    public void stop(){
        bossGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        TestClientHandler handler1=new TestClientHandler();
        TestClient client=new TestClient(handler1);
        new Thread(client).start();
        System.out.println("started");
        handler1.send("blabla");
        Thread.sleep(100);
        client.stop();
        System.out.println("ended");
    }
}
