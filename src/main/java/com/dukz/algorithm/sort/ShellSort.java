package com.dukz.algorithm.sort;

/**
 * @author dukezheng
 * @ClassName ShellSort
 * @Description 希尔排序
 * @date 2021/6/16 14:15
 * @Version 1.0
 */
public class ShellSort {
	public static void sort(int[] a, int n){
		for(int step = n/2; step>=1; step/=2){
			// 插入排序
			for (int i = step; i < n; i++) {
				int value = a[i];
				int j = i-step;
				for (; j >= 0; j-=step) {
					if(a[j] > value){
						a[j+step] = a[j];
					}else {
						break;
					}
				}
				a[j+step] = value;
			}
		}
	}
}
