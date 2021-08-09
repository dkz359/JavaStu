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
	}
}
