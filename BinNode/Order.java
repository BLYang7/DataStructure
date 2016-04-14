package com.BinNode;
/**
 * 前序遍历二叉树
 *
 */
public class Order {

	//前序遍历，先遍历跟节点，再遍历左子树，后遍历右子树
	private static void preOrder(BinNode root){
		if( root == null ){
			return;
		}
		System.out.print(root.Element + "  "); //遍历打印输出
		preOrder(root.Left);
		preOrder(root.Right);
	}
	
	//中序遍历，先遍历左节点，再遍历跟节点，后遍历右子树
	private static void middleOrder(BinNode root){
		if( root == null ){
			return;
		}
		middleOrder(root.Left);
		System.out.print( root.Element + "  " );
		middleOrder(root.Right);
	}
	
	//后序遍历, 先遍历左节点，再遍历右节点，最后遍历根节点
	private static void postOrder(BinNode root){
		if( root == null ){
			return;
		}
		postOrder(root.Left);
		postOrder(root.Right);
		System.out.print( root.Element + "  " );
	}
	
	//测试
	public static void main(String[] args) {
		preOrder(Common.root);
		System.out.println("\n------------------");
		middleOrder(Common.root);
		System.out.println("\n------------------");
		postOrder(Common.root);
	}
	
}
