package com.example.demo.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;
import java.util.Set;

public class NioServerDemo {
    public static void main(String[] args) throws Exception{
        //创建服务端的通道对象，用老接受所有的请求的接入
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //配置通道的io模式（必须设置）
        serverSocketChannel.configureBlocking(false);//true表示阻塞模式，false表示非阻塞
        //获取服务连接对象
        ServerSocket serverSocket = serverSocketChannel.socket();
        //绑定一个端口
        serverSocket.bind(new InetSocketAddress(9001));

        //创建selector选择器
        Selector selector = Selector.open();

        //将通道注册到选择器，并设置监听那种类型的事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            selector.select();//阻塞代码，知道发生监听的事件产生，会在select-key集合中生成事件的key

            Set<SelectionKey> selectionKeySet = selector.selectedKeys();//获取选择器监听到的key集合


            //遍历selectionKeySet，处理多个接受到连接请求
            for(SelectionKey key:selectionKeySet){
                SocketChannel client;
                if(key.isAcceptable()){
                    System.out.println("连接成功");
                    //获取ServerSocketChannel，每个监听到的key都能找到对应的通道对象
                    ServerSocketChannel serverSocketChannel1 =(ServerSocketChannel) key.channel();
                    //接受连接，返回与客户端的连接通道
                    client = serverSocketChannel1.accept();
                    System.out.println(client);
                    //设置连接为非阻塞
                    client.configureBlocking(false);
                    //注册到selector选择器,并监听读取事件
                    client.register(selector,SelectionKey.OP_READ);

                }else if(key.isReadable()){//当事件为读取时
                    client = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(10);
                    byteBuffer.clear();
                    int count = client.read(byteBuffer);
                    if(count>0){
                        byteBuffer.flip();
                        System.out.println(byteBuffer.position()+":"+byteBuffer.limit());
                        Charset charset = Charset.forName("utf-8");
                        String recvmess = String.valueOf(charset.decode(byteBuffer).array());
                        System.out.println(recvmess);
                        System.out.println(byteBuffer.position()+":"+byteBuffer.limit());
                        client.write(byteBuffer);
                    }

                }

            }

            selectionKeySet.clear();

        }

    }
}
