package com.BinNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 树结构
 */
public class TreeNode {

	/**
	 * 定义一棵二叉树
	 */
	private static class BinNode{
		public int Element;
		public BinNode Left;
		public BinNode Right;
		public BinNode(int element){
			this.Element = element;
		}
		public BinNode(int element, BinNode left, BinNode right){
			this.Element = element;
			this.Left = left;
			this.Right = right;
		}
		public boolean isLeaf(){
			return this.Left == null && this.Right == null;
		}
	}

	/**
	 * 测试数据的构建
	 */
	public static BinNode root = new BinNode(0);
	public static BinNode left = new BinNode(1);
	public static BinNode right = new BinNode(2);
	public static BinNode leftLeft = new BinNode(3);
	public static BinNode leftRight = new BinNode(4);
	public static BinNode rightLeft = new BinNode(5);
	public static BinNode rightRight = new BinNode(6);
	static{
		root.Left = left;
		root.Right = right;
		left.Left = leftLeft;
		left.Right = leftRight;
		right.Left = rightLeft;
		right.Right = rightRight;
	}
	

	/**
	 * 前序遍历，先遍历跟节点，再遍历左子树，后遍历右子树
	 * @param root 待遍历的根节点
	 */
	private static void preOrder(BinNode root){
		if( root == null ){
			return;
		}
		System.out.print(root.Element + "  "); //遍历打印输出
		preOrder(root.Left);
		preOrder(root.Right);
	}
	
	/**
	 * 中序遍历，先遍历左节点，再遍历跟节点，后遍历右子树
	 * @param root 待遍历的根节点
	 */
	private static void middleOrder(BinNode root){
		if( root == null ){
			return;
		}
		middleOrder(root.Left);
		System.out.print( root.Element + "  " );
		middleOrder(root.Right);
	}
	
	/**
	 * 后序遍历, 先遍历左节点，再遍历右节点，最后遍历根节点
	 * @param root 待遍历的根节点
	 */
	private static void postOrder(BinNode root){
		if( root == null ){
			return;
		}
		postOrder(root.Left);
		postOrder(root.Right);
		System.out.print( root.Element + "  " );
	}
	
	/**
	 * 前序遍历，不用递归实现，使用栈来实现
	 */
	private static void preOrder1(BinNode root){
		Stack stack = new Stack();
		BinNode temp = root;
		
		//入栈
		while( temp != null ){
			System.out.print( temp.Element + "  " );
			if( temp.Right != null ){
				stack.push(temp.Right);
			}
			temp = temp.Left;
		}
		
		//出栈
		while( stack.size() > 0 ){
			temp = (BinNode) stack.pop();
			while( temp != null ){
				System.out.print(temp.Element + "  " );
				if( temp.Right != null ){
					stack.push(temp.Right);
				}
				temp = temp.Left;
			}
		}
	}
	
	
	/**
	 * 中序遍历,不用递归实现，使用栈区来实现
	 * @param root
	 */
	private static void middleOrder1( BinNode root ){
		Stack stack = new Stack();
		BinNode temp = root;
		
		//入栈
		while( temp != null ){
			if( temp != null ){
				stack.push(temp);
			}
			temp = temp.Left;
		}
		
		//出栈
		while( stack.size() > 0 ){
			temp = (BinNode) stack.pop();
			System.out.print( temp.Element + "  ");
			if( temp.Right != null ){
				temp = temp.Right;
				stack.push(temp);
				while( temp != null ){
					if( temp.Left != null){
						stack.push(temp.Left);
					}
					temp = temp.Left;
				}
			}
		}
	}
	
	
	/**
	 * 后序遍历，不用递归实现，使用栈来记录。这里有点繁，根节点还是要重新装载进栈
	 * @param root
	 */
	private static void postOrder1( BinNode root ){
		Stack stack = new Stack();
		BinNode temp = root;
		
		//入栈
		while(temp != null){
			if(temp != null){
				stack.push(temp);
			}
			temp = temp.Left;
		}
		
		//出栈
		while( stack.size() > 0 ){
			BinNode lastVisit = temp;
			temp = (BinNode) stack.pop();
			if(temp.Right == null || temp.Right == lastVisit){
				System.out.print( temp.Element + "  " );
			} else if ( temp.Left == lastVisit ){
				stack.push(temp);  //再装载进去
				temp = temp.Right;
				stack.push(temp);
				while( temp != null ){
					if( temp.Left != null ){
						stack.push(temp.Left);
					}
					temp = temp.Left;
				}
			}
		}
	}
	
	
	/**
	 * 逐层打印二叉树的每一层 层次遍历
	 * 采用广度搜索优先的遍历方法，利用队列的方式实现
	 */
	private static void printTree( BinNode root ){
		if( root == null ){
			return;
		}
		BinNode tmp = null;
		Queue<BinNode> queue = new LinkedList<BinNode>();
		//队列中把根节点加进去
		queue.add(root);
		//遍历整棵二叉树
		while( !queue.isEmpty() ){
			tmp = (BinNode) queue.poll();
			System.out.print( tmp.Element + "  ");
			
			//将左节点加入到队列中
			if( tmp.Left != null ){
				queue.add(tmp.Left);
			}
			
			//将右节点加入到队列中
			if( tmp.Right != null ){
				queue.add(tmp.Right);
			}
		}
	}
	
	

	/**
	 * 获取二叉树的深度
	 */
	private static int getDepth(BinNode root){
		if( root == null ){
			return 0;
		}
		int leftLength = getDepth(root.Left);
		int rightLength = getDepth(root.Right);
		
		return (leftLength > rightLength ? leftLength : rightLength) + 1;
	}
	
	
	/**
	 * 判断是否为平衡二叉树
	 * 平衡的条件是：左右子树的深度相差不超过1
	 */
	private static boolean isBalanceTree(BinNode root){
		if( root == null ){
			return true;
		}
		
		int leftLength = getDepth(root.Left);
		int rightLength = getDepth(root.Right);
		
		int distance = (leftLength > rightLength) ? (leftLength - rightLength) : (rightLength - leftLength);
		
		if( distance > 1 ){
			return false;
		} else {
			return isBalanceTree(root.Left) && isBalanceTree(root.Right);
		}
	}
	

	
	/**
	 * 寻找两个节点最近的共同父节点
	 * 将两个节点的父节点栈进行对比，一次弹出相同的节点，最后一次弹出的相同节点即为最近的公共父节点
	 */
	private static BinNode findParentNode(BinNode root, BinNode node1, BinNode node2){
		
		java.util.Stack stack1 = new java.util.Stack();
		getPositionByNode(root, node1, stack1);
		
		java.util.Stack stack2 = new java.util.Stack();
		getPositionByNode(root, node2, stack2);
		
		BinNode tempNode = null;
		while( stack1.peek() == stack2.peek() ){
			tempNode = (BinNode) stack1.pop();
			stack2.pop();
		}
		return tempNode;
	}
	//把某个节点的所有父节点依次添加到栈中
	private static boolean getPositionByNode(BinNode root, BinNode node, java.util.Stack stack){
		
		if( root == null ){
			return false;
		}
		else if( root == node ){
			stack.push(root);
			return true;
		}
		else if( getPositionByNode(root.Left, node, stack) || getPositionByNode(root.Right, node, stack) ){
			stack.push(root);
			return true;
		}
		return false;
	}
	
	
	
	//测试
	public static void main(String[] args) {
		//前序遍历，递归调用
		preOrder(root);
		System.out.println();
		
		//中序遍历，递归调用
		middleOrder(root);
		System.out.println();
		
		//后序遍历，递归调用
		postOrder(root);
		System.out.println();
		
		//前序遍历，栈来实现
		preOrder1(root);
		System.out.println();
		
		//中序遍历，栈来实现
		middleOrder1(root);
		System.out.println();
		
		//后序遍历，栈来实现
		postOrder1(root);
		System.out.println();
		
		//层次遍历
		printTree(root);
		System.out.println();
		
		//获取二叉树的深度
		System.out.println(getDepth(root));
		
		//判断是否为平衡二叉树
		System.out.println(isBalanceTree(root));
		
		//寻找两个节点最近的共同父节点
		System.out.println(findParentNode(root, leftLeft, leftRight).Element);
		
	}
	
	
}
