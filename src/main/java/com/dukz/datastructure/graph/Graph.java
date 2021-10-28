package com.dukz.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 数据结构-无向图
 *
 * @author dukezheng
 * @ClassName Graph
 * @date 2021/10/28 12:55
 */
public class Graph {
	/**
	 * 顶点个数
	 */
	private int v;
	/**
	 * 邻接表
	 */
	private LinkedList<Integer>[] adj;
	/**
	 * 初始化一个大小为v的无向图
	 * @Author dukezheng
	 * @Date 13:00 2021/10/28
	 * @Param
	 * @return
	 */
	public Graph(int v){
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	/**
	 * 添加一条边
	 * @Author dukezheng
	 * @Date 13:00 2021/10/28
	 * @Param
	 * @return
	 */
	public void addEdge(int s, int t){
		adj[s].add(t);
		adj[t].add(s);
	}

	/**
	 * 广度优先求最短路径
	 * @Author dukezheng
	 * @Date 13:35 2021/10/28
	 * @Param
	 * @return
	 */
	public void bfs(int s, int t){
		if(s == t){
			return;
		}
		/**
		 * 记录顶点是否访问过
		 */
		boolean[] visited = new boolean[v];
		visited[s] = true;
		/**
		 * 记录节点的前一个节点
		 */
		int[] prev = new int[v];
		for (int i = 0; i < v; i++) {
			prev[i] = -1;
		}
		/**
		 * 存放已访问但相连的顶点还没访问的顶点
		 */
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);

		while (!queue.isEmpty()){
			Integer w = queue.poll();

			LinkedList<Integer> adjw = adj[w];
			for (int i = 0; i < adjw.size(); i++) {
				Integer q = adjw.get(i);
				if(!visited[q]){
					prev[q] = w;
					if(q == t){
						print(prev, s, t);
						return;
					}
					visited[q] = true;
					queue.add(q);
				}
			}
		}
	}

	/**
	 * 打印路径
	 * @Author dukezheng
	 * @Date 14:21 2021/10/28
	 * @Param 
	 * @return 
	 */
	public void print(int[] prev, int s, int t) {
		if(prev[t]!=-1 && s != t){
			print(prev, s, prev[t]);
		}
		System.out.print(t+" ");
	}

}
