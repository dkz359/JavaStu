package com.dukz.algorithm.search;

/**
 * @author dukezheng
 * @ClassName BinarySearch
 * @Description 二分查找
 * @date 2021/8/9 15:44
 * @Version 1.0
 */
public class BinarySearch {
	public static int search(int[] num, int n, int val){
		return binarySearch(num, 0, n-1, val);
	}

	private static int binarySearch(int[] num, int low, int high, int val){
		if(low > high){ return -1;}
		int mid = low + ((high-low)>>2);
		if(num[mid] == val){
			return mid;
		}
		if(num[mid] < val){
			return binarySearch(num, mid+1, high, val);
		}else{
			return binarySearch(num, low, mid-1, val);
		}
	}
}
