package com.dukz.datastructure.heap;

/**
 * @author dukezheng
 * @ClassName MinHeap
 * @Description 小根堆
 * @date 2021/9/26 11:04
 */
public class MinHeap {
	private int capcity;
	private int count;
	private int[] num;

	public MinHeap(int capcity) {
		num = new int[capcity + 1];
		this.capcity = capcity;
		count = 0;
	}

	/**
	 * @Author dukezheng
	 * @Description 删除（堆顶）最小的元素
	 * @Date 11:24 2021/9/26
	 * @Param
	 * @return
	 */
	public void removeMin(){
		// 堆为空
		if (count == 0) { return ; }
		// 将堆最后的元素放到堆顶，然后调整
		num[1] = num[count];
		--count;
		heapify(num, count, 1);
	}

	/**
	 * @Author dukezheng
	 * @Description 从上往下堆调整
	 * @Date 11:25 2021/9/26
	 * @Param
	 * @return
	 */
	public void heapify(int[] num, int count, int i){
		while (true){
			int minPos = i;
			if(i*2<count && num[i*2]<num[minPos]){
				minPos=i*2;
			}
			if(i*2<count+1 && num[i*2+1]<num[minPos]){
				minPos=i*2+1;
			}
			if(minPos == i){
				break;
			}
			swap(num, i, minPos);
			i = minPos;
		}
	}

	/**
	 * @Author dukezheng
	 * @Description 插入新元素
	 * @Date 11:15 2021/9/26
	 * @Param
	 * @return
	 */
	public void insert(int data) {
		// 堆满了
		if (count == capcity) {
			return;
		}
		count++;
		num[count] = data;
		// 堆调整
		int i = count;
		// 从下往上调整
		while (i / 2 != 0 && num[i] < num[i / 2]) {
			swap(num, i, i / 2);
			i = i / 2;
		}
	}

	/**
	 * @Author dukezheng
	 * @Description 交换数组指定位置元素
	 * @Date 11:15 2021/9/26
	 * @Param
	 * @return
	 */
	public void swap(int[] num, int a, int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
}
