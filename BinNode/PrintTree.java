package com.BinNode;
/**
 * 从二叉树的顶部逐层打印
 * 广度优先搜索 BFS
 *
 */
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {
	
	/**
	 * 逐层打印二叉树的每一层
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
	
	//测试
	public static void main(String[] args) {
		printTree(Common.root);
	}
}





