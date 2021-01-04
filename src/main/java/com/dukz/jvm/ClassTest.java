package com.dukz.jvm;

import java.lang.reflect.Field;

/**
 * @ClassName ClassTest
 * @Description ClassTest
 * @Author dukz
 * @Date 12/28/20
 * @Version 1.0
 */
public class ClassTest {
    private static int[] array = new int[3];
    private static int length = array.length;

    private static Class<One> one = One.class;
    private static Class<Another> another = Another.class;

    public static void main(String[] args) throws Exception {
        One oneObject = one.newInstance();
        oneObject.call();

        Another anotherObject = another.newInstance();
        anotherObject.speak();

        Field privateFieldInOne = one.getDeclaredField("inner");
        privateFieldInOne.setAccessible(true);
        privateFieldInOne.set(oneObject, "world changed.");

        System.out.println(oneObject.getInner());
    }
}

class One {
    private String inner = "time flies.";

    public void call (){
        System.out.println("hello world.");
    }

    public String getInner(){
        return inner;
    }
}

class Another{
    public void speak(){
        System.out.println("easy coding.");
    }
}
