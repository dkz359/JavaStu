package com.dukz.proxy.dynamicproxy.cglib;

import com.dukz.proxy.SmsService;
import com.dukz.proxy.SmsServiceImpl;

/**
 * @ClassName CglibProxyDemo
 * @Description cglib代理测试
 * @Author dukz
 * @Date 6/10/21
 * @Version 1.0
 */
public class CglibProxyDemo {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) CglibProxyFactory.getProxy(SmsServiceImpl.class);
        smsService.send("cglib dynamic proxy");
    }
}
