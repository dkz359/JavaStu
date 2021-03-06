package com.dukz.proxy.dynamicproxy.jdk;

import com.dukz.proxy.SmsService;
import com.dukz.proxy.SmsServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author dukezheng
 * @ClassName JdkProxyDemo
 * @Description 测试jdk动态代理
 * @date 2021/6/10 20:46
 * @Version 1.0
 */
public class JdkProxyDemo {
	public static void main(String[] args) {
		SmsService smsService = new SmsServiceImpl();
		SmsService proxy = (SmsService)JdkProxyFactory.getProxy(smsService);

		proxy.send("jdk dynamic proxy");
	}
}
