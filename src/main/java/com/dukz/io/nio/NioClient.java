package com.dukz.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * NIO客户端
 *
 * @author dukezheng
 * @ClassName NioClient
 * @date 2022/5/18 15:21
 */
public class NioClient {
    private static final String host = "127.0.0.1";
    private static final int port = 8484;
    private Selector selector;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                NioClient client = new NioClient();
                client.connect(host, port);
                client.listen();
            }).start();
        }
    }

    public void connect(String host, int port){
        try{
            SocketChannel sc = SocketChannel.open();
            sc.configureBlocking(false);
            this.selector = Selector.open();
            sc.register(selector, SelectionKey.OP_CONNECT);
            sc.connect(new InetSocketAddress(host, port));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void listen(){
        while (true){
            try{
                int events = selector.select();
                if(events > 0){
                    Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
                    while (selectionKeys.hasNext()){
                        SelectionKey selectionKey = selectionKeys.next();
                        selectionKeys.remove();
                        // 连接事件
                        if(selectionKey.isConnectable()){
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            if(socketChannel.isConnectionPending()){
                                socketChannel.finishConnect();
                            }

                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            socketChannel.write(ByteBuffer.wrap(("hello this is "+Thread.currentThread().getName()).getBytes(StandardCharsets.UTF_8)));
                        }else if(selectionKey.isReadable()){
                            SocketChannel sc = (SocketChannel) selectionKey.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            sc.read(buffer);
                            buffer.flip();
                            System.out.println("收到服务端的数据："+new String(buffer.array(), StandardCharsets.UTF_8));
                        }
                    }
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
