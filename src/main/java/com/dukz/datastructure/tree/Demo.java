package com.dukz.datastructure.tree;

/**
 * @author dukezheng
 * @ClassName Demo
 * @Description 测试二叉树
 * @date 2021/8/27 21:17
 */
public class Demo {
	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(3);
		bst.insert(1);
		bst.insert(2);
		bst.insert(4);
		bst.insert(5);
		bst.remove(3);
		bst.preOrder(bst.root);
		System.out.println();
		bst.inOrder(bst.root);
		System.out.println();
		bst.postOrder(bst.root);
	}
}
