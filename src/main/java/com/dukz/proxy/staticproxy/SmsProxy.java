package com.dukz.proxy.staticproxy;

import com.dukz.proxy.SmsService;

/**
 * @author dukezheng
 * @ClassName SmsProxy
 * @Description 短信服务代理类
 * @date 2021/6/10 20:18
 * @Version 1.0
 */
public class SmsProxy implements SmsService {
	private final SmsService smsService;

	public SmsProxy(SmsService smsService) {
		this.smsService = smsService;
	}

	@Override public String send(String message) {
		// 调用代理方法前，添加额外的操作
		System.out.println("before method send()");
		smsService.send(message);
		// 调用代理方法后，添加额外的操作
		System.out.println("after method send()");
		return null;
	}
}
