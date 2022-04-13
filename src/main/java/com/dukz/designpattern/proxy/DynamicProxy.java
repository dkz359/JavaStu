package com.dukz.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxy
 * @Author dukz
 * @Date 2022/3/16
 * @Version 1.0
 */
public class DynamicProxy<T> {
    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler handler){

        return (T) Proxy.newProxyInstance(loader, interfaces, handler);
    }
}
