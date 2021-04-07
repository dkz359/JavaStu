package com.dukz.JMM;

import org.openjdk.jol.info.ClassLayout;

/**
 * @ClassName ObjectHeaderExample
 * @Description 对象头测试
 * @Author dukz
 * @Date 3/25/21
 * @Version 1.0
 */
public class ObjectHeaderExample {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
