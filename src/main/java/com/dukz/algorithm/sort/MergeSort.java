package com.dukz.algorithm.sort;

/**
 * @author dukezheng
 * @ClassName MergeSort
 * @Description 归并排序
 * @date 2021/7/26 14:33
 * @Version 1.0
 */
public class MergeSort {

	public static void sort(int[] a, int n) {
		merge_sort(a, 0, n-1);
	}

	public static void merge_sort(int[] a, int p, int r) {
		if (p >= r) {
			return;
		}
		int q = (p + r) / 2;
		merge_sort(a, p, q);
		merge_sort(a, q + 1, r);
		merge(a, p, r);
	}

	public static void merge(int[] a, int p, int r) {
		int len = r - p + 1;
		int[] tmp = new int[len];
		int q = (p + r) / 2;
		int i=p,j=q+1,k=0;
		while (i <= q && j <= r) {
			if(a[i] < a[j]){
				tmp[k++] = a[i++];
			}else{
				tmp[k++] = a[j++];
			}
		}
		int start = i<=q ? i : j;
		int end = i<=q ? q : r;
		while (start <= end){
			tmp[k++] = a[start++];
		}
		for(int m = 0; m < len; m++){
			a[p+m] = tmp[m];
		}
	}
}
