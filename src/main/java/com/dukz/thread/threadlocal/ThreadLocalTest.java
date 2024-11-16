package com.dukz.thread.threadlocal;

import org.apache.commons.lang3.StringUtils;

/**
 * 测试ThreadLocal
 *
 * @ClassName ThreadLocalTest
 * @Author dukz
 * @Date 2022/9/26
 * @Version 1.0
 */
public class ThreadLocalTest {
    private static ThreadLocal threadLocal = ThreadLocal.withInitial(()-> "init value1");

    public static void main(String[] args) {
        if (threadLocal.get() == null){
            threadLocal.set("data");
        }
        System.out.println(threadLocal.get());
        threadLocal.set("data");
        System.out.println(threadLocal.get());
    }
}
