package com.dukz.jvm.outofmemory;

/**
 * @ClassName JavaVMStackSOF
 * @Description java栈溢出
 * @Author dukz
 * @Date 9/8/21
 * @Version 1.0
 */
public class JavaVMStackSOF {
    /*
    * VM args: -Xss160k
    * */
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: "+oom.stackLength);
            throw e;
        }
    }
}
