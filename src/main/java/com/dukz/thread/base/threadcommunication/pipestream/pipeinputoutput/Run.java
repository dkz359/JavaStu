package com.dukz.thread.base.threadcommunication.pipestream.pipeinputoutput;

import com.dukz.utils.SleepUtils;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @ClassName Run
 * @Description 测试管道字节流通信
 * @Author dukz
 * @Date 6/3/21
 * @Version 1.0
 */
public class Run {
    public static void main(String[] args) {
        try {
            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            // 将输入输出管道连接，连接一次即可
            //inputStream.connect(outputStream);
            outputStream.connect(inputStream);

            PipeInputThread pipeInputThread = new PipeInputThread(inputStream);
            pipeInputThread.start();

            SleepUtils.second(2);

            PipeOutputThread pipeOutputThread = new PipeOutputThread(outputStream);
            pipeOutputThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
