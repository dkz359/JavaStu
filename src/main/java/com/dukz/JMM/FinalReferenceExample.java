package com.dukz.JMM;

/**
 * @ClassName FinalReferenceExample
 * @Description final域为引用类型
 * @Author dukz
 * @Date 3/16/21
 * @Version 1.0
 */
public class FinalReferenceExample {
    final int[] intArr;                     // final是引用类型
    static FinalReferenceExample obj;

    public FinalReferenceExample(){         // 构造函数
        intArr = new int[1];                // 1
        intArr[0] = 1;                      // 2
    }

    public static void writeOne(){          // 写线程A执行
        obj = new FinalReferenceExample();  // 3
    }

    public static void writeTwo(){          // 写线程B执行
        obj.intArr[0] = 2;                  // 4
    }

    public static void reader(){            // 读线程C执行
        if(obj != null){                    // 5
            int temp = obj.intArr[0];       // 6
        }
    }
}
