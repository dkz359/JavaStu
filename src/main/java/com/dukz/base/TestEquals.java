package com.dukz.base;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName TestEquals
 * @Description TODO
 * @Author dukz
 * @Date 2020-06-15
 * @Version 1.0
 */
public class TestEquals {
    public static void main(String[] args) {
        String str1 = new String("abd");
        String str2 = new String("abd");
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        // HashSet底层判断重复是通过hashCode值
        Set<String> set1 = new HashSet<>();
        set1.add(str1);
        set1.add(str2);
        System.out.println(set1.size());

        Person p1 = new Person("p");
        Person p2 = new Person("p");
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        Set<Person> set2 = new HashSet<>();
        set2.add(p1);
        set2.add(p2);
        System.out.println(set2.size());

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s6 = s5.intern();
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  // true
        System.out.println(s1 == s4);  // false
        System.out.println(s1 == s9);  // false
        System.out.println(s4 == s5);  // false
        System.out.println(s1 == s6);  // true
        System.out.println(s1 == s9.intern());  // true
    }
}

class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name){
        this.name = name;
    }


}
