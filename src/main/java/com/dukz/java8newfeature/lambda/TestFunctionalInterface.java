package com.dukz.java8newfeature.lambda;

/**
 * @author dukezheng
 * @ClassName TestFunctionInterface
 * @Description TODO 函数式接口指的是只有一个函数的接口，这样的接口可以隐式转换成Lambda表达式，@FunctionalInterface注解用来
 *                   显示说明该接口是函数式接口，默认方法和静态方法不会破坏函数式接口的定义
 * @date 2020/10/30 16:24
 * @Version 1.0
 */
@FunctionalInterface
public interface TestFunctionalInterface {
    void test1();
    default void defaultMethod(){
        System.out.println("this is a default method...");
    }
}
