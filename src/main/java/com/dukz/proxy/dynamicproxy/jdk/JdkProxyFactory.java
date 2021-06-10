package com.dukz.proxy.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @ClassName JdkProxyFactory
 * @Description jdk动态代理工厂
 * @Author dukz
 * @Date 6/10/21
 * @Version 1.0
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new SmsInvocationHandler(target));
    }
}
