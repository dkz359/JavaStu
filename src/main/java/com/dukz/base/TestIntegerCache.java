package com.dukz.base;

/**
 * @ClassName TestIntegerCache
 * @Description TestIntegerCache
 * Integer的缓存只要使用了valueOf方法就会使用缓存，Integer的自动装箱会调用valueOf()
 * @Author dukz
 * @Date 2020-12-02
 * @Version 1.0
 */
public class TestIntegerCache {
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

        System.out.println(i3 == i5);
        System.out.println(i1 == i5);
        System.out.println(i1 == i3);
        System.out.println("-------------------------------");
        int i = 123;
        // 与int类型比较时会自动拆箱，变成基础数据类型，直接比较值
        System.out.println(i == i1);
        System.out.println(i == i3);
        System.out.println(i == i5);
        System.out.println(i3 == i);
        System.out.println(i5 == i);
    }
}
