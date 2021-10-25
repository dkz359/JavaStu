package com.dukz.designpattern.principle.lsp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 父类
 * @ClassName Father
 * @Author dukz
 * @Date 2021/10/25
 * @Version 1.0
 */
public class Father {
    //public Collection doSomething(HashMap map){
    public Collection doSomething(Map map){
        System.out.println("父类方法执行……");
        return map.values();
    }
}
