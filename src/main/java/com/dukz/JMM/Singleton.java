package com.dukz.JMM;

/**
 * @author dukezheng
 * @ClassName Singleton
 * @Description 双重校验锁单例DCL
 * @date 2021/3/17 15:55
 * @Version 1.0
 */
public class Singleton {
    public volatile static Singleton instance;

    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (Singleton.class){
                if (instance == null) {
                    // 分配内存
                    // 对象初始化
                    // 引用指向地址
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
