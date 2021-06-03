package com.dukz.thread.base.threadcommunication.pipestream.pipereaderwriter;

import java.io.IOException;
import java.io.PipedReader;

/**
 * @ClassName PipeReaderThread
 * @Description 从PipedReader中读取字符流
 * @Author dukz
 * @Date 6/3/21
 * @Version 1.0
 */
public class PipeReaderThread extends Thread{
    private PipedReader reader;

    public PipeReaderThread(PipedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            System.out.println("read:");
            char[] chars = new char[20];
            // PipedWriter中没有数据时会阻塞
            int readLen = reader.read(chars);
            while (readLen != -1){
                String newData = new String(chars, 0, readLen);
                System.out.print(newData);
                readLen = reader.read(chars);
            }
            System.out.println();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
