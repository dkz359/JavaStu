package com.dukz.JMM;

/**
 * @ClassName FinalExample
 * @Description final域重排序
 * @Author dukz
 * @Date 3/16/21
 * @Version 1.0
 */
public class FinalExample {
    int i;                  // 普通变量
    final int j;            // final变量
    static FinalExample obj;

    public FinalExample(){  // 构造函数
        i = 1;              // 写普通域
        j = 2;              // 写final域
    }

    public static void writer(){    // 写线程A执行
        obj = new FinalExample();
    }

    public static void reader(){    // 读现场B执行
        FinalExample object = obj;  // 读对象引用
        int a = object.i;           // 读普通域
        int b = object.j;           // 读final域
    }
}
