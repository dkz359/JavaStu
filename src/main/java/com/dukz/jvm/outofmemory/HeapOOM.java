package com.dukz.jvm.outofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HeapOOM
 * @Description 测试堆OOM
 * @Author dukz
 * @Date 9/7/21
 * @Version 1.0
 */
public class HeapOOM {
    /*
    * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
    * */
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true){
            list.add(new OOMObject());
        }
    }

}
