package com.dukz.datastructure.lineartable.list;

import org.w3c.dom.Node;

/**
 * @author dukezheng
 * @ClassName LinkedList
 * @Description 单向链表
 * @date 2021/5/12 20:50
 * @Version 1.0
 */
public class LinkedList<T> {
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

	public LinkedList(Node head) {
		this.head = head;
	}

	public LinkedList() {
	}

	/**
	 * 头结点，初始化空的结点
	 */
	private Node head = new Node(null, null);

	/**
	 * 链表添加元素，头插法
	 * @param data
	 * @param <T>
	 * @return
	 */
	public <T> boolean add(T data){
		Node<T> node = new Node<>(head.next, data);
		head.next = node;
		return true;
	}

	/**
	 * 删除指定值的元素
	 * @param o
	 * @return
	 */
	public boolean remove(Object o){
		if(o == null){
			for (Node<T> x=head.next,pre = head; x!=null; pre=x,x=x.next){
				if(x.data == null){
					pre.next = x.next;
					x=null;
					return true;
				}
			}
		}else{
			for (Node<T> x=head.next,pre = head; x!=null; pre=x,x=x.next){
				if(o.equals(x.data)){
					pre.next = x.next;
					x=null;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 打印list
	 */
	public <T> void printList(){
		Node<T> cur = head;
		while (cur.next!=null){
			cur = cur.next;
			System.out.print(cur.data+" ");
		}
	}
}

