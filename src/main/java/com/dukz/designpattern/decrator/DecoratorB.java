package com.dukz.designpattern.decrator;

public class DecoratorB extends Decorator {
	public DecoratorB(Component component) {
		super(component);
	}

	private void method(){
		System.out.println("装饰B。。。");
	}

	@Override
	public void operate() {
		super.operate();
		this.method();
	}
}
