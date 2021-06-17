package com.dukz.algorithm.sort;

/**
 * @author dukezheng
 * @ClassName SelectionSort
 * @Description 选择排序
 * 每次【选择】未排序的数组中最小的元素放到已排序数组的末尾
 * @date 2021/6/16 13:46
 * @Version 1.0
 */
public class SelectionSort {
	public static void sort(int[] a, int n){
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i+1; j < n; j++) {
				if (a[j] < a[minIndex]){
					minIndex = j;
				}
			}
			if(minIndex != i) {
				int temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		}
	}
}
