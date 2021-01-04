package com.dukz.java8newfeature.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dukezheng
 * @ClassName TestStream
 * @Description TODO
 * @date 2020/12/15 19:44
 * @Version 1.0
 */
public class TestStream {
    public static void main(String[] args) {

        List<Integer> numbers  = Arrays.asList(3, 2, 1, 4, 5, 2, 3);

        // map
        List<Integer> squaresList = numbers .stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);

        // filter
        long count = numbers.stream().filter(i -> i > 2).count();
        System.out.println(count);

        // limit
        Random random = new Random();
        random.ints().limit(2).forEach(System.out::println);

        // sorted
        numbers.stream().sorted().forEach(System.out::println);

        // parallel
        long count1 = numbers.parallelStream().filter(i -> i > 3).count();
        System.out.println(count1);

        // Collectors
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> collect = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("is not empty collect: "+collect);

        String joins = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("joins: "+joins);

        // summaryStatistics
        IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("min: "+stats.getMin());
        System.out.println("sum: "+stats.getSum());
        System.out.println("avg: "+stats.getAverage());
    }
}
