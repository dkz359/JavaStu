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
		int mid = low + ((high-low)>>1);
		if(num[mid] == val){
			return mid;
		}
		if(num[mid] < val){
			return binarySearch(num, mid+1, high, val);
		}else{
			return binarySearch(num, low, mid-1, val);
		}
	}


	/**
	 * @Author dukezheng
	 * @Description 查找第一个等于给定值
	 * @Date 21:15 2021/8/10
	 * @Param 
	 * @return 
	 */
	public static int firstEqualSearch(int[] num, int n, int val){
		int low = 0,high = n-1;
		int mid;
		while (low <= high){
			mid = low + ((high - low)>>1);
			if(num[mid] < val){
				low = mid +1;
			}else if(num[mid] > val){
				high = mid -1;
			}else{
				if(mid == 0 || num[mid-1] != val){
					return mid;
				}else{
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	/**
	 * @Author dukezheng
	 * @Description 查找最后一个等于给定值
	 * @Date 10:14 2021/8/11
	 * @Param
	 * @return
	 */
	public static int lastEqualSearch(int[] num, int n, int val){
		int low = 0,high = n-1;
		int mid;
		while (low <= high){
			mid = low + ((high - low)>>1);
			if(num[mid] < val){
				low = mid +1;
			}else if(num[mid] > val){
				high = mid -1;
			}else{
				if(mid == n-1 || num[mid+1] != val){
					return mid;
				}else{
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	/**
	 * @Author dukezheng
	 * @Description 第一个大于等于给定值
	 * @Date 12:38 2021/8/11
	 * @Param
	 * @return
	 */
	public static int firstGreaterEqualSearch(int[] num, int n, int val){
		int low = 0,high = n-1;
		int mid;
		while (low <= high){
			mid = low + ((high - low)>>1);
			if(num[mid] < val){
				low = mid +1;
			}else{
				if(mid == 0 || num[mid-1] < val){
					return mid;
				}else{
					high = mid - 1;
				}
			}
		}
		return -1;
	}


	/**
	 * @Author dukezheng
	 * @Description 查找最后一个小于等于给定值
	 * @Date 10:14 2021/8/11
	 * @Param
	 * @return
	 */
	public static int lastLessEqualSearch(int[] num, int n, int val){
		int low = 0,high = n-1;
		int mid;
		while (low <= high){
			mid = low + ((high - low)>>1);
			if(num[mid] > val){
				high = mid -1;
			}else{
				if(mid == n-1 || num[mid+1] > val){
					return mid;
				}else{
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}
