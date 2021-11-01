package com.dukz.datastructure.graph;

/**
 * 图测试
 *
 * @author dukezheng
 * @ClassName GraphDemo
 * @date 2021/10/28 14:28
 */
public class GraphDemo {
	public static void main(String[] args) {
		Graph graph = new Graph(8);
		graph.addEdge(1,2);
		graph.addEdge(1,3);
		graph.addEdge(1,4);
		graph.addEdge(2,1);
		graph.addEdge(2,5);
		graph.addEdge(3,1);
		graph.addEdge(3,2);
		graph.addEdge(3,4);
		graph.addEdge(3,6);
		graph.addEdge(4,1);
		graph.addEdge(4,3);
		graph.addEdge(4,6);
		graph.addEdge(4,7);
		graph.addEdge(5,2);
		graph.addEdge(6,3);
		graph.addEdge(6,4);
		graph.addEdge(6,7);
		graph.addEdge(7,4);
		graph.addEdge(7,6);
		graph.bfs(2, 7);
		System.out.println();
		graph.dfs(2,7);
	}
}
