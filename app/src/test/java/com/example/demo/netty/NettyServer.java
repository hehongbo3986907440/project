package com.example.demo.netty;

import com.example.demo.netty.handler.PrintMessHandler;
import com.example.demo.netty.handler.ResponseHandler;
import com.example.demo.netty.handler.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

public class NettyServer {
    //线程组
    //接受客户端连接的线程组
    private EventLoopGroup acceptGroup = null;
    //处理客户端数据的线程组
    private EventLoopGroup workGroup = null;
    //服务的配置对象
    private ServerBootstrap serverBootstrap = null;

    private ServerBootstrap init(){
        acceptGroup = new NioEventLoopGroup();
        workGroup = new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(acceptGroup,workGroup);
        serverBootstrap.channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(10000));
//        serverBootstrap.option(ChannelOption.SO_RCVBUF,1024);
//        serverBootstrap.option(ChannelOption.SO_KEEPALIVE,true);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                //字符串解码处理器
                socketChannel.pipeline().addLast("decoder", new StringDecoder());
                socketChannel.pipeline().addLast("encoder", new StringEncoder());
                //自定义读取逻辑处理器
                socketChannel.pipeline().addLast(new SimpleChannelInboundHandler() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
                        System.out.println("Server channelRead....");
                        System.out.println(channelHandlerContext.channel().remoteAddress()+"->Server :"+msg.toString());
                        channelHandlerContext.write("Server write"+msg);
                        channelHandlerContext.flush();
                    }

                });
//                socketChannel.pipeline().addLast(new ServerHandler());
            }
        });
        return serverBootstrap;
    }
//
    public static void main(String[] args){
        try {
            NettyServer server = new NettyServer();
            ServerBootstrap serverBootstrap = server.init();
            ChannelFuture future = serverBootstrap.bind(10000).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    private int port;
//
//    public NettyServer(int port) {
//        this.port = port;
//    }
//
//    public void start() {
//
//        // netty服务端ServerBootstrap启动的时候,默认有两个eventloop分别是bossGroup和 workGroup
//
//        EventLoopGroup boosGroup = new NioEventLoopGroup(1);   // bossGroup
//        EventLoopGroup workerGroup = new NioEventLoopGroup();  // workGroup
//        try {
//            ServerBootstrap sbs = new ServerBootstrap().group(boosGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .localAddress(new InetSocketAddress(port))
//                    .childHandler(new ChannelInitializer<SocketChannel>() {
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast("decoder", new StringDecoder());
//                            ch.pipeline().addLast("encoder", new StringEncoder());
//                            ch.pipeline().addLast(new ServerHandler());
//                        };
//                    }).option(ChannelOption.SO_BACKLOG, 128)
//                    .childOption(ChannelOption.SO_KEEPALIVE, true);
//
//            ChannelFuture future = sbs.bind(port).sync();
//            System.out.println("Server start listen at " + port);
//            future.channel().closeFuture().sync();
//        } catch (Exception e) {
//            boosGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        int port;
//        if (args.length > 0) {
//            port = Integer.parseInt(args[0]);
//        } else {
//            port = 10000;
//        }
//        new NettyServer(port).start();
//    }
}
