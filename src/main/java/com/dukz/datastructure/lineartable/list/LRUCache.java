package com.dukz.datastructure.lineartable.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dukezheng
 * @ClassName LRUCache
 * @Description 利用list实现LRU
 * @date 2021/5/31 10:55
 * @Version 1.0
 */
public class LRUCache<T> {
	private LinkedList<T> CACHE;
	/**
	 * default cache size = 5
	 */
	private Integer size = 5;
	/**
	 * cache count
	 */
	private Integer count = 0;

	public LRUCache(Integer size) {
		this.size = size;
		init();
	}

	public LRUCache() {
		init();
	}
	public void init(){
		CACHE = new LinkedList<T>();
	}

	public T get(T obj){
		if(obj == null){
			throw new IllegalArgumentException("不能为null");
		}
		// 是否在缓存中
		boolean inCache = false;
		for (T val : CACHE) {
			if(obj.equals(val)){
				// 已经在缓存中，删除当前位置的元素，插入到链表头部
				removeVal(val);
				addFirst(obj);
				inCache = true;
				break;
			}
		}
		// 不在缓存中，1.缓存已满，删除尾部节点，头部添加；2.缓存没满，直接插入头部
		if(!inCache){
			// 从数据库查
			if(size.equals(count)){
				removeLast();
				addFirst(obj);
			}else{
				addFirst(obj);
				count++;
			}
		}
		return obj;
	}

	/**
	 * 添加在链表头部
	 * @return
	 */
	public boolean addFirst(T obj){
		CACHE.addFirst(obj);
		return true;
	}

	/**
	 * 删除当前节点
	 * @return
	 */
	public boolean removeVal(T obj){
		CACHE.remove(obj);
		return true;
	}
	/**
	 * 删除链表尾部的节点
	 * @return
	 */
	public boolean removeLast(){
		T t = CACHE.pollLast();
		System.out.println("最久未使用："+t);
		return true;
	}
}
