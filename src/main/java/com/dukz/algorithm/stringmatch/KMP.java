package com.dukz.algorithm.stringmatch;

/**
 * 字符串匹配：KMP算法
 *
 * @author dukezheng
 * @ClassName KMP
 * @date 2022/1/19 15:19
 */
public class KMP {

	/**
	 * kmp算法主要方法
	 *
	 * @author dukz
	 * @param a 主串
	 * @param n 主串长度
	 * @param b 模式串
	 * @param m 模式串长度
	 * @return {@link int}
	 * @date 2022/1/19 16:05
	 **/
	public static int kmp(char[] a, int n, char[] b, int m){
		// next数组，存放不同长度的好前缀的最长可匹配前缀子串结束下标
		int[] next = getNexts(b, m);
		int j = 0;
		for (int i = 0; i < n; i++) {
			while (j>0 && a[i]!=b[j]){
				j = next[j-1]+1;
			}
			if(a[i] == b[j]){
				++j;
			}
			if(j == m){
				return i-m+1;
			}
		}

		return -1;
	}

	// b表示模式串，m表示模式串的长度
	private static int[] getNexts(char[] b, int m) {
		int[] next = new int[m];
		next[0] = -1;
		int k = -1;
		for (int i = 1; i < m; ++i) {
			while (k != -1 && b[k + 1] != b[i]) {
				k = next[k];
			}
			if (b[k + 1] == b[i]) {
				++k;
			}
			next[i] = k;
		}
		return next;
	}
}
