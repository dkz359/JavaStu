package com.dukz.JMM;

/**
 * @ClassName VolatileTest2
 * @Description volatile测试2
 * @Author dukz
 * @Date 3/16/21
 * @Version 1.0
 */
public class VolatileTest2 {
    long a = 1L; 				// 64 位的 long 型普通变量
    public synchronized void set(long l) {	//对单个普通变量的写用同一个锁同步
        a = l;
    }
    public synchronized long get() {		//对单个普通变量的读用同一个锁同步
        return a;
    }
    public void getAndIncreament() {		//普通方法调用
        long temp = get();					//调用已同步的读方法
        temp += 1L;							//普通写操作
        set(temp);							//调用已同步的写方法
    }
}
