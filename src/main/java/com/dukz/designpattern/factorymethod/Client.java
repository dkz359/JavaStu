package com.dukz.designpattern.factorymethod;

/**
 * 场景类
 */
public class Client {
	public static void main(String[] args) {
		Creator creator = new ConcreteCreator();
		Product product1 = creator.createProduct(ConcreteProduct1.class);
		// 业务逻辑处理
	}
}
