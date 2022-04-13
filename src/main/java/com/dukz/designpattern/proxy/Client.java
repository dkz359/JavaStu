package com.dukz.designpattern.proxy;


/**
 * 场景类
 *
 * @ClassName Client
 * @Author dukz
 * @Date 2022/3/16
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        MyInvocationHandler handler = new MyInvocationHandler(subject);
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
        proxy.doSomething("hahaha");
    }
}
