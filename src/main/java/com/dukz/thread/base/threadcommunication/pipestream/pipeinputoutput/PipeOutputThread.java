package com.dukz.thread.base.threadcommunication.pipestream.pipeinputoutput;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @ClassName PipeOutputThread
 * @Description 向PipeOutputStream写字节流
 * @Author dukz
 * @Date 6/3/21
 * @Version 1.0
 */
public class PipeOutputThread extends Thread{
    private PipedOutputStream out;

    public PipeOutputThread(PipedOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            System.out.println("write:");
            for (int i = 0; i < 300; i++) {
                String outData = ""+(i+1);
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
