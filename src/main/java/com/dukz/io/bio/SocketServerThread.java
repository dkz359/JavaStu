package com.dukz.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * socketserver接收消息
 *
 * @author dukezheng
 * @ClassName SocketServerThread
 * @date 2022/5/17 10:05
 */
public class SocketServerThread extends Thread{
    private Socket socket;
    private String name;

    public SocketServerThread(Socket socket,String name) {
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
        Accepter accepter = new Accepter(socket,name);
        Sender sender = new Sender(socket,name);
        accepter.start();
        sender.start();
    }

    class Accepter extends Thread{
        private Socket socket;
        private String name;

        public Accepter(Socket socket,String name) {
            this.socket = socket;
            this.name = name;
        }

        @Override
        public void run() {
            String message="";
            try {
                BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));;
                int i=1;
                do{
                    message = in.readLine();
                    System.out.println("服务端第"+i+"次接收到来自<<"+name+">>信息为:"+message);
                    i++;
                }while (!"exit".equals(message));
                //当客户端输入exit退出后，关闭socket输入流
                //in.close();  //这种关闭流的方法会导致socket关闭
                socket.shutdownInput();
                System.out.println("服务端已停止接收<<"+name+">>的数据");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    class Sender extends Thread{
        private Socket socket;
        private String name;

        public Sender(Socket socket,String name) {
            this.socket = socket;
            this.name = name;
        }

        @Override
        public void run() {
            int i= 1;
            String readLine = "";

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                do{
                    readLine = br.readLine();
                    if(null != readLine){
                        writer.println(readLine);
                        writer.flush();
                    }
                    System.out.println("服务端第"+i+"次发送信息给<<"+name+">>,信息为:"+readLine);
                    i++;
                }while (!"exit".equals(readLine));
                //br.close();   //注意这里的控制台输入流不能关闭,在多线程的情况下有可能出现A线程正在读，而B线程已经关闭了该流的情况
                //writer.close(); //采用流关闭方式会导致socket关闭
                socket.shutdownOutput();
                System.out.println("服务端停止发送数据给<<"+name+">>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
