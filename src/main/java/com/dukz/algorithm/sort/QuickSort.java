package com.dukz.algorithm.sort;

import com.dukz.tools.ArrayUtils;

/**
 * @author dukezheng
 * @ClassName QuickSort
 * @Description 快速排序：取分区点pivot，小于pivot的在左边，大于pivot的在右边
 * @date 2021/7/30 21:08
 * @Version 1.0
 */
public class QuickSort {
	public static void sort(int[] a, int n){
		quick_sort(a, 0, n-1);
	}

	/**
	 * 快速排序，先获取分区点，在递归分区排序
	 * @param a
	 * @param p
	 * @param r
	 */
	public static void quick_sort(int[] a, int p, int r){
		if(p>=r){return;}
		int q = partition(a, p, r);
		quick_sort(a, p, q-1);
		quick_sort(a, q+1, r);
	}


	/**
	 * 获取pivot所在下标
	 * @return
	 */
	public static int partition(int[] a, int p, int r){
		int pivot = a[r];
		int i = p;
		for (int j = p; j <= r - 1; j++) {
			if(a[j] < pivot){
				ArrayUtils.swap(a, i, j);
				i++;
			}
		}
		ArrayUtils.swap(a, i, r);
		return i;
	}

}
