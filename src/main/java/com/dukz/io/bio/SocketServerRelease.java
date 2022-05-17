package com.dukz.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 传统阻塞io示例
 *
 * @author dukezheng
 * @ClassName TraditionalSocketServer
 * @date 2022/5/16 11:46
 */
public class SocketServerRelease extends Thread{
    public static ServerSocket server = null;

    static{
        try {
            server = new ServerSocket(5209);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println("******服务器已启动，等待客户端连接*****");
        Socket socket = null;
        int i=1;
        try {
            while(true){
                //循环监听客户端的连接
                socket = server.accept();
                //新建一个线程ServerSocket，并开启
                System.out.println("开启第"+i+"个socket");
                new SocketServerThread(socket,"第"+i+"个socket").start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
