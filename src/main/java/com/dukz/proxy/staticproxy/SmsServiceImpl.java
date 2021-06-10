package com.dukz.proxy.staticproxy;

/**
 * @author dukezheng
 * @ClassName SmsServiceImpl
 * @Description 发送短信服务
 * @date 2021/6/10 20:17
 * @Version 1.0
 */
public class SmsServiceImpl implements SmsService {

	@Override public String send(String message) {
		System.out.println("send message: "+message);
		return message;
	}
}
