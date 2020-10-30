package com.dukz.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dukezheng
 * @ClassName ListTest
 * @Description 深拷贝测试
 * @date 2020/9/23 19:13
 * @Version 1.0
 */
public class DeepCopyTest {
    public static void main(String[] args) {
        List<User> a = new ArrayList<>();
        a.add(new User("a",12));
        a.add(new User("b",12));
        a.add(new User("c",12));
        System.out.println(a);
        List<User> b = new ArrayList<>();
        for (User user : a) {
            b.add(user.clone());
        }
        System.out.println(b);
        System.out.println("================");
        b.get(0).setAge(18);
        System.out.println(a);
        System.out.println(b);
    }
}

class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override protected User clone() {
        return new User(this.name, this.age);
    }
}
