package com.dukz.designpattern.prototype;

/**
 * 原型模式的通用代码
 */
public class PrototypeClass implements Cloneable {
	// 覆写父类Object的方法
	@Override
	public Object clone() {
		PrototypeClass prototypeClass = null;
		try {
			prototypeClass = (PrototypeClass)super.clone();
		} catch (CloneNotSupportedException e) {
			// 异常处理
		}
		return prototypeClass;
	}
}
