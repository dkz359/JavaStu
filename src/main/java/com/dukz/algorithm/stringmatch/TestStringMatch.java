package com.dukz.algorithm.stringmatch;

/**
 * 测试字符串匹配
 *
 * @author dukezheng
 * @ClassName TestStringMatch
 * @date 2022/1/19 17:42
 */
public class TestStringMatch {
	public static void main(String[] args) {
		String strA = "ababababacd";
		String strB = "ababacd";
		char[] a = strA.toCharArray();
		char[] b = strB.toCharArray();
		System.out.println(BM.bm(a, a.length, b, b.length));
		System.out.println(KMP.kmp(a, a.length, b, b.length));
	}
}
