package com.dukz.designpattern.proxy;

/**
 * @ClassName RealSubject
 * @Author dukz
 * @Date 2022/3/16
 * @Version 1.0
 */
public class RealSubject implements Subject{

    @Override
    public void doSomething(String str) {
        System.out.println(str+"...");
    }
}
