package com.dukz.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * NIO服务器
 *
 * @author dukezheng
 * @ClassName NioServer
 * @date 2022/5/18 15:00
 */
public class NioServer {
    private int port;
    private Selector selector;
    private ExecutorService service = new ThreadPoolExecutor(5,5,5, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>());

    public NioServer(int port){
        this.port = port;
    }

    public static void main(String[] args) {
        new NioServer(8484).start();
    }

    public void init(){
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(port));
            selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Nioserver started......");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void accept(SelectionKey key){
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel sc = ssc.accept();
            sc.configureBlocking(false);
            sc.register(selector, SelectionKey.OP_READ);
            System.out.println("accept a client : "+sc.socket().getInetAddress().getHostName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start(){
        this.init();
        while (true){
            try {
                int events = selector.select();
                if(events > 0){
                    Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
                    while (selectionKeyIterator.hasNext()){
                        SelectionKey selectionKey = selectionKeyIterator.next();
                        selectionKeyIterator.remove();
                        if(selectionKey.isAcceptable()){
                            this.accept(selectionKey);
                        }else{
                            service.submit(new NioServerHandler(selectionKey));
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static class NioServerHandler implements Runnable{

        private SelectionKey selectionKey;

        public NioServerHandler(SelectionKey selectionKey) {
            this.selectionKey = selectionKey;
        }

        @Override
        public void run() {
            try {
                if(selectionKey.isReadable()){
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    System.out.println("收到客户端"+channel.socket().getInetAddress().getHostName()+"的数据："+new String(buffer.array(), StandardCharsets.UTF_8));
                    // 将数据添加到key中
                    ByteBuffer outBuffer = ByteBuffer.wrap(buffer.array());
                    // 回传消息给客户端
                    channel.write(outBuffer);
                    selectionKey.cancel();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
