package com.dukz.designpattern.principle.lsp;

import java.util.HashMap;

/**
 * 测试用
 * @ClassName Client
 * @Author dukz
 * @Date 2021/10/25
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        Father f = new Father();
        //Son f = new Son();
        HashMap<Object, Object> map = new HashMap<>();
        f.doSomething(map);
    }
}
