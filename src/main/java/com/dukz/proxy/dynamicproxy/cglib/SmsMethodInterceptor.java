package com.dukz.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName SmsMethodInterceptor
 * @Description 自定义方法拦截器
 * @Author dukz
 * @Date 6/10/21
 * @Version 1.0
 */
public class SmsMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method : "+ method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after method : "+ method.getName());
        return result;
    }
}
