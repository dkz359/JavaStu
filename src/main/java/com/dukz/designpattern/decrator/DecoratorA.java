package com.dukz.designpattern.decrator;

public class DecoratorA extends Decorator {
	public DecoratorA(Component component) {
		super(component);
	}

	private void method(){
		System.out.println("装饰A。。。");
	}

	@Override
	public void operate(){
		this.method();
		super.operate();
	}
}
