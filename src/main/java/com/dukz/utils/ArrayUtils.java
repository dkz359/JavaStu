package com.dukz.utils;

/**
 * @author dukezheng
 * @ClassName ArrayUtils
 * @Description 数组工具方法
 * @date 2021/7/30 21:45
 * @Version 1.0
 */
public class ArrayUtils {

	/**
	 * 交换数组指定下标的元素
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
