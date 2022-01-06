package com.dukz.designpattern.factorymethod;

/**
 * 抽象工厂类
 */
public abstract class Creator {
	// 通常为String,Enum,Class等，当然也可以为空
	public abstract <T extends Product> T createProduct(Class<T> c);
}
