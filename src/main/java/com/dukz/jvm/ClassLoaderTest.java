package com.dukz.jvm;

/**
 * 测试ClassLoader
 *
 * @ClassName ClassLoaderTest
 * @Author dukz
 * @Date 2022/9/23
 * @Version 1.0
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader appCL = ClassLoaderTest.class.getClassLoader();
        System.out.println(appCL);

        //获取扩展类加载器
        ClassLoader extCL = appCL.getParent();
        System.out.println(extCL);
    }
}
