package com.dukz.java8newfeature.optional;

import java.util.Optional;

/**
 * @author dukezheng
 * @ClassName OptionalTest
 * @Description TODO
 * @date 2020/12/2 18:08
 * @Version 1.0
 */
public class OptionalTest {
    public static void main(String[] args) {
//        Optional<String> fullName = Optional.ofNullable(null);
        Optional<String> fullName = Optional.ofNullable("Tom");
        System.out.println("Full name is set ?"+fullName.isPresent());
        System.out.println("Full name: "+fullName.orElseGet(()->"[none]"));
        System.out.println(fullName.map(s->"hey "+ s+"!").orElse("hey stranger!"));
    }
}
