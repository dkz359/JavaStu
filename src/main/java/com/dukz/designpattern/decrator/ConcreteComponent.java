package com.dukz.designpattern.decrator;

public class ConcreteComponent implements Component {
	@Override
	public void operate() {
		System.out.println("被装饰方法。。。");
	}
}
