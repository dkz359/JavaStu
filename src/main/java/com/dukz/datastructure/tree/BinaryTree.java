package com.dukz.datastructure.tree;

import static com.sun.deploy.uitoolkit.impl.awt.AWTClientPrintHelper.print;

/**
 * @author dukezheng
 * @ClassName BinaryTree
 * @Description 二叉树
 * @date 2021/8/23 12:34
 */
public class BinaryTree {
	public Node root;

	/**
	 * @Author dukezheng
	 * @Description 前序遍历
	 * @Date 21:08 2021/8/27
	 * @Param
	 * @return
	 */
	public void preOrder(Node p){
		if (p == null) {
			return;
		}
		print(p);
		preOrder(p.left);
		preOrder(p.right);
	}

	/**
	 * @Author dukezheng
	 * @Description 中序遍历
	 * @Date 21:17 2021/8/27
	 * @Param
	 * @return
	 */
	public void inOrder(Node p){
		if (p == null) {
			return;
		}
		inOrder(p.left);
		print(p);
		inOrder(p.right);
	}
	/**
	 * @Author dukezheng
	 * @Description 后序遍历
	 * @Date 21:17 2021/8/27
	 * @Param
	 * @return
	 */
	public void postOrder(Node p){
		if (p == null) {
			return;
		}
		postOrder(p.left);
		postOrder(p.right);
		print(p);
	}

	public void print(Node node){
		if (node != null) {
			System.out.print(node.data+" ");
		}
	}

}

/**
 * 二叉树的节点
 */
class Node{
	public int data;
	public Node left;
	public Node right;

	public Node(int data) {
		this.data = data;
	}
}
