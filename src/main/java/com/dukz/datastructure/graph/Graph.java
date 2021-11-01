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
	 * 标记是否已经找到
	 */
	private boolean found = false;
	/**
	 * 获取路径-深度优先
	 * @Author dukezheng
	 * @Date 9:24 2021/11/1
	 * @Param 
	 * @return
	 */
	public void dfs(int s, int t){
		/**
		 * 记录顶点是否访问过
		 */
		boolean[] visited = new boolean[v];
		/**
		 * 记录节点的前一个节点
		 */
		int[] prev = new int[v];
		for (int i = 0; i < v; i++) {
			prev[i] = -1;
		}
		recurDfs(s, t, visited, prev);
		print(prev, s, t);
	}

	/**
	 * 递归查找
	 * @Author dukezheng
	 * @Date 9:29 2021/11/1
	 * @Param
	 * @return
	 */
	private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
		if(found == true){
			return;
		}
		visited[w] = true;
		if(w == t){
			found = true;
			return;
		}
		for (int i = 0; i < adj[w].size(); i++) {
			Integer p = adj[w].get(i);
			if(!visited[p]){
				prev[p] = w;
				recurDfs(p, t, visited, prev);
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
