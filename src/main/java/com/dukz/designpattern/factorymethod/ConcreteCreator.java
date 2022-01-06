package com.dukz.designpattern.factorymethod;

/**
 * 具体工厂类
 */
public class ConcreteCreator extends Creator {
	@Override public <T extends Product> T createProduct(Class<T> c) {
		Product product = null;
		try {
			product = c.newInstance();
		} catch (Exception e) {
		}
		return (T)product;
	}
}
