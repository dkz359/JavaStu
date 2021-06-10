package com.dukz.proxy.staticproxy;

import com.dukz.proxy.SmsService;
import com.dukz.proxy.SmsServiceImpl;

/**
 * @author dukezheng
 * @ClassName SmsProxyDemo
 * @Description 使用代理发送消息
 * @date 2021/6/10 20:20
 * @Version 1.0
 */
public class SmsProxyDemo {
	public static void main(String[] args) {
		SmsService smsService = new SmsServiceImpl();
		SmsProxy smsProxy = new SmsProxy(smsService);
		smsProxy.send("static proxy");
	}
}
