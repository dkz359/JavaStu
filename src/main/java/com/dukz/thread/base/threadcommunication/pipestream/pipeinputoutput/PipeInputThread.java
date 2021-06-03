package com.dukz.thread.base.threadcommunication.pipestream.pipeinputoutput;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @ClassName PipeInputThread
 * @Description 从PipeinputStream读取字节流
 * @Author dukz
 * @Date 6/3/21
 * @Version 1.0
 */
public class PipeInputThread extends Thread{
    private PipedInputStream input;

    public PipeInputThread(PipedInputStream input) {
        this.input = input;
    }

    @Override
    public void run() {
        try {
            System.out.println("read:");
            byte[] bs = new byte[20];
            // 当管道没数据会阻塞在此处
            int readLen = input.read(bs);
            while (readLen != -1){
                String inData = new String(bs, 0, readLen);
                System.out.print(inData);
                readLen = input.read(bs);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
