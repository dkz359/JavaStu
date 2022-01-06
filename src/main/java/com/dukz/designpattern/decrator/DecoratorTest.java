package com.dukz.designpattern.decrator;

public class DecoratorTest {
	public static void main(String[] args) {
		Component component = new ConcreteComponent();

		component = new DecoratorA(component);
		component = new DecoratorB(component);

		component.operate();
	}
}
