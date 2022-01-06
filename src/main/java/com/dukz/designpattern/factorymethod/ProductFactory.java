package com.dukz.designpattern.factorymethod;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {
	private static final Map<String, Product> prMap = new HashMap<>();
	public static synchronized Product createProduct(String type){
		Product product = null;
		if(prMap.containsKey(type)){
			return prMap.get(type);
		}else{
			if("Product1".equals(type)){
				product = new ConcreteProduct1();
			}else{
				product = new ConcreteProduct2();
			}
			prMap.put(type, product);
		}
		return product;
	}
}


	/*public static <T extends Product> T createProduct(Class<T> c){
		Product product=null;
		try {
			product = c.newInstance();
		}catch (Exception e){
			System.out.println("发生异常");
		}
		return (T)product;
	}*/