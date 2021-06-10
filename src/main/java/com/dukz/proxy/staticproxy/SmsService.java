package com.dukz.proxy.staticproxy;

/**
 * @author dukezheng
 * @ClassName SmsService
 * @Description 发送短信接口定义
 * @date 2021/6/10 20:16
 * @Version 1.0
 */
public interface SmsService {
	/**
	 * 发送短信
	 * @param message
	 * @return
	 */
	String send(String message);
}
