package com.BinNode;

import java.util.Stack;

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
	
	//前序遍历，不用递归实现，使用栈来实现
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
	
	
	//中序遍历,不用递归实现，使用栈区来实现
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
	
	
	//后序遍历，不用递归实现，使用栈来记录。这里有点繁，根节点还是要重新装载进栈
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
	
	
	//测试
	public static void main(String[] args) {
		preOrder(Common.root);
		System.out.println("\n-------------------");
		middleOrder(Common.root);
		System.out.println("\n-------------------");
		postOrder(Common.root);
		System.out.println("\n-------------------");
		preOrder1(Common.root);
		System.out.println("\n-------------------");
		middleOrder1(Common.root);
		System.out.println("\n-------------------");
		postOrder1(Common.root);
	}
	
}
