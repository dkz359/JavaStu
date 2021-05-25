package com.dukz.datastructure.lineartable.list;

/**
 * @author dukezheng
 * @ClassName LinkedList
 * @Description 单向链表
 * @date 2021/5/12 20:50
 * @Version 1.0
 */
public class LinkedList {
	/**
	 * @Author dukezheng
	 * @Description 单向链表的节点
	 * @Date 20:50 2021/5/12
	 */
	private static class Node<T>{
		private Node next;
		private T data;

		public Node(Node next, T data) {
			this.next = next;
			this.data = data;
		}
	}

	private Node head;
}

