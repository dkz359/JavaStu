package com.dukz.designpattern.factorymethod;

public abstract class AbstractProductFactory {
	public abstract Product createProduct();
}

class ConcreteProduct1Factory extends AbstractProductFactory {
	@Override public Product createProduct() {
		return new ConcreteProduct1();
	}
}