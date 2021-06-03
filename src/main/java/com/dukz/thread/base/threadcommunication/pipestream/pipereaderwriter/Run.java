package com.dukz.thread.base.threadcommunication.pipestream.pipereaderwriter;


import com.dukz.tools.SleepUtils;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @ClassName Run
 * @Description 测试管道字符流实现线程通信
 * @Author dukz
 * @Date 6/3/21
 * @Version 1.0
 */
public class Run {
    public static void main(String[] args) {
        try {
            PipedReader pipedReader = new PipedReader();
            PipedWriter pipedWriter = new PipedWriter();

            // 连接两个字符流
            //pipedReader.connect(pipedWriter);
            pipedWriter.connect(pipedReader);

            PipeReaderThread readerThread = new PipeReaderThread(pipedReader);
            readerThread.start();

            SleepUtils.second(2);

            PipeWriterThread writerThread = new PipeWriterThread(pipedWriter);
            writerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
