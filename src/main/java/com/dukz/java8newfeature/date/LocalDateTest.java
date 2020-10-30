package com.dukz.java8newfeature.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
    public static void main(String[] args) {
//        LocalDate localDate = LocalDate.now();
//        LocalDate localDate = LocalDate.of(2020,5,20);
//        LocalDate localDate = LocalDate.parse("2020-06-30");
        LocalDate localDate = LocalDate.parse("2020/06/20", DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        System.out.println("localDate: "+localDate);

        LocalDate localDate1 = localDate.minusMonths(1);

        System.out.println("localDate1: "+localDate1);

        LocalDate localDate2 = localDate.plusDays(31);

        System.out.println("localDate2: "+localDate2);

        LocalTime now = LocalTime.now();
        System.out.println("now: "+now);

        LocalTime now1 = LocalTime.parse("09:30");
        System.out.println("now1: "+now1);
        LocalTime now2 = LocalTime.of(9,50);
        System.out.println("now2: "+now2);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("dateTime: "+dateTime);
        LocalDateTime dateTime1 = LocalDateTime.of(localDate, now1);
        System.out.println("dateTime1: "+dateTime1);
        LocalDateTime parse = LocalDateTime.parse("2020-08-27 09:30:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("parse: "+parse);
    }
}
