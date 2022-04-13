package com.dukz.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MyInvocationHandler
 * @Author dukz
 * @Date 2022/3/16
 * @Version 1.0
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object obj){
        this.target = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前代理");
        Object result = method.invoke(this.target, args);
        System.out.println("方法执行后代理");
        return result;
    }
}
