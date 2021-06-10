package com.dukz.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @ClassName CglibProxyFactory
 * @Description cglib代理类工厂
 * @Author dukz
 * @Date 6/10/21
 * @Version 1.0
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz){
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        //设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        //设置被代理的类
        enhancer.setSuperclass(clazz);
        //设置方法拦截器
        enhancer.setCallback(new SmsMethodInterceptor());
        // 创建代理
        return enhancer.create();
    }
}
