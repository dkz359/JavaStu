package com.dukz.base;

/**
 * @author dukezheng
 * @ClassName TestGeneric
 * @Description TODO
 * @date 2020/12/3 11:35
 * @Version 1.0
 */
public class TestGeneric {
    public static void main(String[] args) {
        Pair<String> pp = new Pair<>("123", "456");
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);
    }
    static int add(Pair<? extends Number> p){
        Number key = p.getKey();
        Number value = p.getValue();
        return key.intValue()+value.intValue();
    }
}

class Pair<T>{
    private T key;
    private T value;
    public Pair(T key, T value){
        this.key = key;
        this.value = value;
    }
    public T getKey(){
        return key;
    }
    public T getValue(){
        return value;
    }

}
