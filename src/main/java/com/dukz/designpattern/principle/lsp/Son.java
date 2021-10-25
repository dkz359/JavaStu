package com.dukz.designpattern.principle.lsp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 子类
 * @ClassName Son
 * @Author dukz
 * @Date 2021/10/25
 * @Version 1.0
 */
public class Son extends Father{
    //public Collection doSomething(Map map) {
    public Collection doSomething(HashMap map) {
        System.out.println("子类方法执行……");
        return map.values();
    }
}
