package com.example.demo.netty;

import com.example.demo.netty.handler.Client01Handler;
import com.example.demo.netty.handler.Client02Handler;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

public class NettyClient {
    private EventLoopGroup workGroup;

    private Bootstrap bootstrap;

    private void init(){
        workGroup = new NioEventLoopGroup();

        bootstrap = new Bootstrap();
        bootstrap.group(workGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast("decoder", new StringDecoder());
                socketChannel.pipeline().addLast("encoder", new StringEncoder());
                socketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        System.out.println(msg);
                    }
                });
//                socketChannel.pipeline().addLast(new Client01Handler());
//                socketChannel.pipeline().addLast(new Client02Handler());
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        NettyClient nettyClient = new NettyClient();
        nettyClient.init();
        ChannelFuture channelFuture = nettyClient.bootstrap.connect("127.0.0.1",10000).sync();
//        while (true){
        channelFuture.channel().writeAndFlush("Hello Netty Server, I am a common client");
//            Thread.sleep(2000);
//        }
    }
//    static final String HOST = System.getProperty("host", "127.0.0.1");
//    static final int PORT = Integer.parseInt(System.getProperty("port", "10000"));
//    static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));
//
//    public static void main(String[] args) throws Exception {
//        EventLoopGroup group = new NioEventLoopGroup();
//        try {
//            Bootstrap b = new Bootstrap();
//            b.group(group)
//                    .channel(NioSocketChannel.class)
//                    .option(ChannelOption.TCP_NODELAY, true)
//                    .handler(new ChannelInitializer<SocketChannel>(){
//                        @Override
//                        public void initChannel(SocketChannel ch) throws Exception {
//                            ChannelPipeline p = ch.pipeline();
//                            p.addLast("decoder", new StringDecoder());
//                            p.addLast("encoder", new StringEncoder());
//                            p.addLast(new Client01Handler());
//                            p.addLast(new Client02Handler());
//                        }
//                    });
//
//            ChannelFuture future = b.connect(HOST, PORT).sync();
//            future.channel().writeAndFlush("Hello Netty Server, I am a common client");
//            future.channel().closeFuture().sync();
//        } finally {
//            group.spliterator();
//        }
//    }
}
