package com.dukz.java8newfeature.lambda;

import lombok.NoArgsConstructor;

/**
 * @author dukezheng
 * @ClassName LambdaTest
 * @Description TODO
 * @date 2020/10/30 16:34
 * @Version 1.0
 */

@NoArgsConstructor
public class LambdaTest {


    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();
        test.test(()->{
            System.out.println("成功调用函数式接口。。。");
        });
    }

    public void test(TestFunctionalInterface tfl){
        tfl.test1();
    }
}
