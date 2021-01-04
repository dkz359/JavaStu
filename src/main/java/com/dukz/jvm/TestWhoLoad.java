package com.dukz.jvm;

/**
 * @ClassName TestWhoLoad
 * @Description 测试哪个类加载器加载
 * @Author dukz
 * @Date 12/29/20
 * @Version 1.0
 */
public class TestWhoLoad {
    public static void main(String[] args) {
        // 正在使用的类加载器：sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader c = TestWhoLoad.class.getClassLoader();
        System.out.println(c);

        // AppClassLoader的父加载器是：sun.misc.Launcher$ExtClassLoader@4d7e1886
        ClassLoader c1 = c.getParent();
        System.out.println(c1);

        // ExtClassLoader的父加载器是BooStrap。它是使用C++实现的，不在JVM体系中，返回null
        ClassLoader c2 = c1.getParent();
        System.out.println(c2);
    }
}
