package com.dukz.java8newfeature.stream;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author dukezheng
 * @ClassName Streams
 * @Description TODO
 * @date 2020/12/2 18:14
 * @Version 1.0
 */
public class Streams {
    private enum Status{
        OPEN,CLOSED
    }

    private static final class Task{
        private final Status status;
        private final Integer points;
        Task(final Status status, final Integer points){
            this.status = status;
            this.points = points;
        }

        public Integer getPoints(){
            return points;
        }

        public Status getStatus(){
            return status;
        }

        @Override public String toString() {
            return String.format("[%s; %d]", status, points);
        }
    }

    public static void main(String[] args) {
        final Collection<Task> tasks = Arrays.asList(
            new Task(Status.OPEN, 5),
            new Task(Status.OPEN, 13),
            new Task(Status.CLOSED, 8)
        );

        // 首先，tasks集合被转换成steam表示；
        // 其次，在steam上的filter操作会过滤掉所有CLOSED的task；
        // 第三，mapToInt操作基于每个task实例的Task::getPoints方法将task流转换成Integer集合；
        // 最后，通过sum方法计算总和，得出最后的结果
        final int sum = tasks.stream().filter(task -> task.getStatus() == Status.OPEN).mapToInt(Task::getPoints).sum();
        System.out.println("Total points: "+sum);
    }
}
