package com.dukz.jvm;

/**
 * 测试Clinit方法
 *
 * @ClassName ClinitTest
 * @Author dukz
 * @Date 2022/9/23
 * @Version 1.0
 */
public class ClinitTest {
    private int a = 1;
    public static int b = 2;

    static {
        b=20;
    }

    public static void main(String[] args) {
        int c = 3;
        System.out.println(ClinitTest.b);
    }

    public ClinitTest() {
        a = 10;
        b = 200;
    }
}
