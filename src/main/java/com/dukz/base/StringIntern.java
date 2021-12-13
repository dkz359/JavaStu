package com.dukz.base;

/**
 * 测试String.inter
 *
 * @ClassName StringIntern
 * @Author dukz
 * @Date 2021/12/13
 * @Version 1.0
 */
public class StringIntern {
    /**
     * string.intern方法：如果字符串在字符串常量池中有直接返回常量池中的地址，否则将当前对象地址放到常量池中并返回
     */
    public static void main(String[] args) {
        String a = "Hell";
        String str  = new String(a+"o");
        System.out.println(str.intern() == str);// true

        String s1 = new StringBuilder(a).append("o").toString();
        System.out.println(s1.intern() == s1);// false
        // 此时"Hello"对应的intern方法都是str对应的地址
        System.out.println(s1.intern() == str);// true
    }
}
