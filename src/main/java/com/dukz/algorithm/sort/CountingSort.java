package com.dukz.algorithm.sort;

/**
 * @author dukezheng
 * @ClassName CountingSort
 * @Description 计数排序
 * @date 2021/8/2 15:56
 * @Version 1.0
 */
public class CountingSort {

	public static void sort(int[] a, int n) {
		// 获取数据范围
		int max = a[0];
		for (int i = 1; i < n; i++) {
			if(max < a[i]){
				max = a[i];
			}
		}
		// 建数据范围大小的数组
		int num[] = new int[max+1];
		for (int i = 0; i <= max; i++) {
			num[i] = 0;
		}
		// 统计每个数据的数量
		for (int i = 0; i < n; i++) {
			num[a[i]]++;
		}
		// 累加数量，得到小于等于下标的数据个数
		for (int i = 1; i <= max; i++) {
			num[i] += num[i-1];
		}
		// 将数组元素作为下标，下标作为元素值，放回到原数组中，数据-1
		int A[] = new int[n];
		for (int i = 0; i < n; i++) {
			A[num[a[i]]-1] = a[i];
			num[a[i]]--;
		}
		// 写回原数组
		for (int i = 0; i < n; i++) {
			a[i] = A[i];
		}
	}
}
