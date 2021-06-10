package com.dukz.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dukezheng
 * @ClassName SmsInvocationHandler
 * @Description jdk的动态代理类
 * @date 2021/6/10 20:40
 * @Version 1.0
 */
public class SmsInvocationHandler implements InvocationHandler {
	/**
	 * 代理类中的真实对象
	 */
	private final Object target;

	public SmsInvocationHandler(Object target) {
		this.target = target;
	}

	@Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 调用方法前添加自己的操作
		System.out.println("before method : "+method.getName());
		Object result = method.invoke(target, args);
		// 调用方法后执行自己的操作
		System.out.println("after method : "+method.getName());
		return result;
	}
}
