package com.dukz.httpserver;

import java.io.IOException;

/**
 * @ClassName HttpServerDemo
 * @Description 测试自定义HttpServer
 * @Author dukz
 * @Date 7/13/21
 * @Version 1.0
 */
public class HttpServerDemo {
    public static void main(String[] args) throws IOException {
        SimpleHttpServer.setPort(80);
        SimpleHttpServer.setBasePath("/Users/dukz/workspace/StuProjects/JavaStu/src/main/java/com/dukz/httpserver");
        SimpleHttpServer.start();
    }
}
