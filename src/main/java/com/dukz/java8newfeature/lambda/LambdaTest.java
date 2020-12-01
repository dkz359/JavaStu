package com.dukz.java8newfeature.lambda;

import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

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

        test.testForeach();
    }

    public void testForeach(){
        // 不指定参数类型，编译器自动推断
        Arrays.asList("a","b","c").forEach(e-> System.out.println(e));

        // 指定参数类型
        Arrays.asList("a","b","c").forEach((String e)-> System.out.println(e));

        // 复杂语句块用花括号括起来
        Arrays.asList("a","b","c").forEach((String e)-> {
            System.out.println(e);
            System.out.println(e);
        });

//        String separator = ",";
        final String separator = ",";
        // lambda中引用类成员和局部变量，会自动将变量隐式转换成final的
        Arrays.asList("a","b","c").forEach(e-> System.out.print(e+separator));

        // lambda表达式有返回值，返回值类型编译器也能推断出。只有一行是可不写return，下面两个代码效果一样
        Arrays.asList("a","b","c").sort((e1,e2)->e1.compareTo(e2));
        Arrays.asList("a","b","c").sort((e1,e2)->{
            int result = e1.compareTo(e2);
            return result;
        });

        Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream.forEach((s)-> System.out.println(s));
    }

    public void test(TestFunctionalInterface tfl){
        tfl.test1();
    }
}
