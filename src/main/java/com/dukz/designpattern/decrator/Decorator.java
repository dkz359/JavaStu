package com.dukz.designpattern.decrator;

public abstract class Decorator implements Component {
	private Component component;

	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public void operate() {
		this.component.operate();
	}
}
