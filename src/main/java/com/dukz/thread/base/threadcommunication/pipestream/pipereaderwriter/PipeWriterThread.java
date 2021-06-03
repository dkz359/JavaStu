package com.dukz.thread.base.threadcommunication.pipestream.pipereaderwriter;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * @ClassName PipeWriterThread
 * @Description 向PipedWriter写字符流
 * @Author dukz
 * @Date 6/3/21
 * @Version 1.0
 */
public class PipeWriterThread extends Thread {
    private PipedWriter writer;

    public PipeWriterThread(PipedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            System.out.println("write:");
            for (int i = 0; i < 300; i++) {
                String outData = ""+(i+1);
                writer.write(outData);
                System.out.print(outData);
            }
            System.out.println();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
