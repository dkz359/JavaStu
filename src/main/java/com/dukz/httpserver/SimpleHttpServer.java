package com.dukz.httpserver;

import com.dukz.thread.threadpool.DefaultThreadPool;
import com.dukz.thread.threadpool.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName SimpleHttpServer
 * @Description 自定义简单的web服务器
 * @Author dukz
 * @Date 7/13/21
 * @Version 1.0
 */
public class SimpleHttpServer {
    // 处理HttoRequest的线程池
    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>();

    static String basePath;
    static ServerSocket serverSocket;
    static int port = 8080;
    public static void setPort(int port){
        if(port>0){
            SimpleHttpServer.port = port;
        }
    }
    public static void setBasePath(String basePath){
        if (basePath!=null && new File(basePath).exists() && new File(basePath).isDirectory()){
            SimpleHttpServer.basePath = basePath;
        }
    }

    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept())!=null){
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }


    static class HttpRequestHandler implements Runnable{
        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                String filePath = basePath+header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());
                if(filePath.endsWith("jpg") || filePath.endsWith("ico")){
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i=0;
                    while ((i=in.read())!=-1){
                        baos.write(i);
                    }
                    byte[] array = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-Length: "+array.length);
                    out.println("");
                    socket.getOutputStream().write(array, 0, array.length);
                }else{
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");
                    while ((line=br.readLine())!=null){
                        out.println(line);
                    }
                }
                out.flush();
            }catch (Exception ex){
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            }finally {
                close(br, in, reader, out, socket);
            }
        }

        private static void close(Closeable... closeables){
            if (closeables != null){
                for (Closeable closeable : closeables) {
                    try {
                        if(closeable!=null) {
                            closeable.close();
                        }
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}
