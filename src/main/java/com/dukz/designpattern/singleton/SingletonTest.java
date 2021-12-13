package com.dukz.designpattern.singleton;

/**
 * @author dukezheng
 * @ClassName SingletonTest
 * @Description 单例测试
 * @date 2021/10/8 14:03
 */
public class SingletonTest {
	public static void main(String[] args) {
		SingletonEnum ins1 = SingletonEnum.getInstance();
		SingletonEnum ins2 = SingletonEnum.getInstance();
		System.out.println(ins1 == ins2);
	}
}
