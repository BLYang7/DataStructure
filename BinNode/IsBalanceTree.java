package com.BinNode;
/**
 * 判断一个二叉树是否为平衡二叉树
 * 		1、计算二叉树深度 
 *		2、判断是否为平衡二叉树。
 *
 *平衡二叉树：任意节点的左右子树的深度相差不超过1，那么这棵树就是平衡二叉树
 */
public class IsBalanceTree {

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
	
	
	 //测试
	public static void main(String[] args) {
		System.out.println(getDepth(Common.root));
		System.out.println(isBalanceTree(Common.root));
	}
	
}
