package com.dukz.algorithm.search;

/**
 * @author dukezheng
 * @ClassName TestSearch
 * @Description 测试查找算法
 * @date 2021/8/9 15:43
 * @Version 1.0
 */
public class TestSearch {
	public static void main(String[] args) {
		int[] num = new int[]{1,2,3,5,6,7,9,11,13};
		int index = BinarySearch.search(num, num.length, 7);
		System.out.println(index);

		int[] num1 = new int[]{1,2,3,7,7,7,9,11,13};
		int index1 = BinarySearch.firstEqualSearch(num1, num1.length, 7);
		System.out.println(index1);
		int index2 = BinarySearch.lastEqualSearch(num1, num1.length, 7);
		System.out.println(index2);
		int index3 = BinarySearch.firstGreaterEqualSearch(num1, num1.length, 8);
		System.out.println(index3);
		int index4 = BinarySearch.lastLessEqualSearch(num1, num1.length, 8);
		System.out.println(index4);
	}
}
