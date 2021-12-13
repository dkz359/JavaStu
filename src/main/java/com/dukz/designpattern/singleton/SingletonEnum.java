package com.dukz.designpattern.singleton;

/**
 * @author dukezheng
 * @ClassName SingletonEnum
 * @Description 通过枚举实现单例
 * @date 2021/10/8 13:59
 */
public class SingletonEnum {
	private SingletonEnum(){}

	public enum SingletonEnumProduct{
		SEED;

		private SingletonEnum singletonEnum;

		SingletonEnumProduct(){
			singletonEnum = new SingletonEnum();
		}

		public SingletonEnum getSingletonEnum() {
			return singletonEnum;
		}
	}

	public static SingletonEnum getInstance(){
		return SingletonEnumProduct.SEED.getSingletonEnum();
	}
}
