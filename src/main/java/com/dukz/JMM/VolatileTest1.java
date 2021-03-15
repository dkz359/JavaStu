package com.dukz.JMM;

/**
 * @ClassName VolatileTest1
 * @Description volatile测试1
 * @Author dukz
 * @Date 3/16/21
 * @Version 1.0
 */
public class VolatileTest1 {
    volatile long a = 1L; 		// 使用 volatile 声明 64 位的 long 型
    public void set(long l) {
        a = l;                  //单个 volatile 变量的写
    }
    public long get() {
        return a;               //单个 volatile 变量的读
    }
    public void getAndIncreament() {
        a++;                    // 复合（多个） volatile 变量的读 /写
    }
}
