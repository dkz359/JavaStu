package com.dukz.test;

import java.util.HashMap;

/**
 * @ClassName TestTemp
 * @Description TODO
 * @Author dukz
 * @Date 2020-06-23
 * @Version 1.0
 */
public class TestTemp {
    public static void main(String[] args) {
        Integer i1 = new Integer(123);
        Integer i2 = new Integer(123);
        System.out.println(i1 == i2);

        Integer i3 = 123;
        Integer i4 = 123;
        System.out.println(i3 == i4);

        Integer i5 = Integer.valueOf(123);
        Integer i6 = Integer.valueOf(123);
        System.out.println(i5 == i6);
    }
}
