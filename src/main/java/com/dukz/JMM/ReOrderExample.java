package com.dukz.JMM;

/**
 * @ClassName ReOrderExample
 * @Description 重排序测试
 * @Author dukz
 * @Date 3/16/21
 * @Version 1.0
 */
public class ReOrderExample {
    int a = 0;
    boolean flag = false;
    public void write() {
        a = 1;			//1
        flag = true;	//2
    }
    public void read() {
        if(flag) {			//3
            int i = a * a;	//4
        }
    }
}
