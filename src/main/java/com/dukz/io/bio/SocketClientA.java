package com.dukz.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端A
 *
 * @author dukezheng
 * @ClassName SocketClientA
 * @date 2022/5/17 10:08
 */
public class SocketClientA {
    static Socket socket;
    static BufferedReader br;  //控制台输入
    static BufferedReader in;  //读取服务端信息输入流
    static PrintWriter writer; //发送给服务端信息的输出流

    class Accepter extends Thread{
        @Override
        public void run() {
            int i= 1;
            String readLine="";
            try {
                do{
                    readLine = in.readLine();
                    if(null != readLine){
                        System.out.println(readLine);
                    }
                    System.out.println("客户端第"+i+"次接收信息为:"+readLine);
                    i++;
                }while(!"exit".equals(readLine));
                //关闭socket输入流
                //in.close();  采用关闭流的方式会导致socket被关闭
                socket.shutdownInput();
                System.out.println("客户端停止接收数据");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    class Sender extends Thread{
        @Override
        public void run() {
            int i= 1;
            String readLine ="";
            try {
                do{
                    readLine = br.readLine();
                    if(null != readLine){
                        writer.println(readLine);
                        writer.flush();
                        System.out.println("客户端第"+i+"次发送信息为:"+readLine);
                        i++;
                    }
                }while (!"exit".equals(readLine));
                //当客户端输入exit后关闭socket输出流
                br.close();
                //writer.close();  采用流的关闭方式会导致socket关闭
                socket.shutdownOutput();
                System.out.println("客户端停止发送数据");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // 搭建客户端
    public static void main(String[] args) throws IOException {
        try {
            // 1、创建客户端Socket，指定服务器地址和端口
            socket = new Socket("127.0.0.1",5209);
            System.out.println("客户端启动成功");
            SocketClientA socketClient = new SocketClientA();
            Sender sender = socketClient.new Sender();
            Accepter accepter = socketClient.new Accepter();
            br = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());

            sender.start();
            accepter.start();


        } catch (Exception e) {
            // 出错，打印出错信息
            System.out.println("can not listen to:" + e);
        }
    }

}