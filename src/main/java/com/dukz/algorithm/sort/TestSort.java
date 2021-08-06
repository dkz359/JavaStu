package com.dukz.algorithm.sort;

/**
 * @author dukezheng
 * @ClassName TestSort
 * @Description 测试排序方法
 * @date 2021/6/4 16:57
 * @Version 1.0
 */
public class TestSort {
	public static void main(String[] args) {
		int[] a = new int[]{3,5,4,1,2,6};
		// BubbleSort.sort(a, a.length);
		// InsertionSort.sort(a, a.length);
		// SelectionSort.sort(a, a.length);
		// ShellSort.sort(a, a.length);
		// MergeSort.sort(a, a.length);
		// QuickSort.sort(a, a.length);
		CountingSort.sort(a, a.length);
		printArray(a);
	}

	public static void printArray(int[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
