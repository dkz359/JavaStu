package com.dukz.java8newfeature.methodrefrence;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author dukezheng
 * @ClassName MethodRefrence
 * @Description TODO    方法引用使得开发者可以直接引用现存的方法、Java类的构造方法或者实例对象。
 *      方法引用和Lambda表达式配合使用，使得java类的构造方法看起来紧凑而简洁，没有很多复杂的模板代码。
 * @date 2020/12/1 16:07
 * @Version 1.0
 */
public class MethodRefrence {

    public static class Car{
        public static Car create(Supplier<Car> supplier){
            return supplier.get();
        }

        public static void collide(Car car){
            System.out.println("Collide "+car.toString());
        }

        public void follow(Car another){
            System.out.println("Following the "+another.toString());
        }

        public void repair(){
            System.out.println("Repaired "+this.toString());
        }
    }

    public static void main(String[] args) {

        // 构造器引用，语法是Class::new，构造器没有参数
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        // 静态方法引用，语法是Class::static_method，方法有一个Car类型参数
        cars.forEach(Car::collide);

        // 类的成员方法引用，语法是Class::Method，方法没有参数
        cars.forEach(Car::repair);

        // 实例对象的成员方法引用，语法是instance::method，方法有一个Car类型参数
        cars.forEach(car::follow);
    }
}
