package com.dukz.algorithm.sort;

/**
 * @author dukezheng
 * @ClassName InsertionSort
 * @Description 插入排序
 * 依次将未排序数组中的元素【插入】到已排序的数组中
 * @date 2021/6/16 12:42
 * @Version 1.0
 */
public class InsertionSort {

	public static void sort(int[] a, int n){
		if(n<=1){
			return;
		}
		for (int i = 1; i < n; ++i) {
			int value = a[i];
			int j = i-1;
			for (; j >= 0; --j) {
				if(a[j] > value){
					// 移动
					a[j+1] = a[j];
				}else{
					break;
				}
			}
			// 插入
			a[j+1] = value;
		}
	}
}
