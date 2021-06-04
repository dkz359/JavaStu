package com.dukz.algorithm.sort;

/**
 * @author dukezheng
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * @date 2021/6/4 16:39
 * @Version 1.0
 */
public class BubbleSort {

	public static void sort(int[] a, int n){
		for (int i = 0; i < n-1; i++) {
			// 用于判断是否有交换
			boolean swap = false;
			for (int j = 0; j < n-i-1; j++) {
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swap = true;
				}
			}
			// 没有交换说明已经有序了
			if (!swap){
				return;
			}
		}
	}
}
