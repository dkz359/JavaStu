package com.dukz.datastructure.tree;

/**
 * @author dukezheng
 * @ClassName BinarySearchTree
 * @Description 二叉查找树
 * @date 2021/8/23 12:48
 */
public class BinarySearchTree extends BinaryTree {

	/**
	 * @Author dukezheng
	 * @Description 查找指定数据
	 * @Date 14:25 2021/8/24
	 * @Param
	 * @return
	 */
	public Node find(int data){
		if(root == null){
			return null;
		}
		Node p = root;
		while(p!=null){
			if(data > p.data){
				p = p.right;
			}else if(data < p.data){
				p = p.left;
			}else{
				return p;
			}
		}
		return null;
	}

	/**
	 * @Author dukezheng
	 * @Description 往查找二叉树中插入值
	 * @Date 19:54 2021/8/24
	 * @Param
	 * @return
	 */
	public void insert(int data){
		if(root == null){
			root = new Node(data);
			return;
		}
		Node p = root;
		while(p != null){
			if(data > p.data){
				if(p.right == null){
					p.right = new Node(data);
					return;
				}
				p = p.right;
			}else{
				if(p.left == null){
					p.left = new Node(data);
					return;
				}
				p = p.left;
			}
		}
	}

	/**
	 * @Author dukezheng
	 * @Description 删除指定元素
	 * @Date 18:24 2021/8/25
	 * @Param
	 * @return
	 */
	public void remove(int data){
		Node p = root;
		// pp 是p的父节点
		Node pp = null;
		while(p!=null && p.data!=data){
			pp = p;
			if(data>p.data){
				p = p.right;
			}else{
				p=p.left;
			}
		}
		// 没找到
		if(p == null){ return; }

		Node minpp = p;
		Node minp = null;
		// 如果p有两个子节点
		if(p.left != null && p.right != null){
			minp = p.right;
			while(minp.left != null){
				minpp = minp;
				minp = minp.left;
			}
			// 找到右子树中最小的节点，将值放到p中，此时要删除的就是minp
			p.data = minp.data;
			pp = minpp;
			p = minp;
		}

		// 如果p有一个子节点
		Node child;
		if(p.left != null){
			child = p.left;
		}else if(p.right != null){
			child = p.right;
		}else{
			child = null;
		}

		// 如果p没有子节点
		if(pp == null){
			root = child;
		}else if (pp.left == p){
			pp.left = child;
		}else{
			pp.right = child;
		}
	}
}
