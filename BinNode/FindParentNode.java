package com.BinNode;
/**
 * 寻找两个节点最近的共同父节点
 *
 */
import java.util.Stack;
public class FindParentNode {

	/**
	 * 把某个节点的所有父节点依次添加到栈中
	 */
	private static boolean getPositionByNode(BinNode root, BinNode node, Stack stack){
		
		if( root == null ){
			return false;
		}
		
		if( root == node ){
			stack.push(root);
			return true;
		}
		
		if( getPositionByNode(root.Left, node, stack) || getPositionByNode(root.Right, node, stack) ){
			stack.push(root);
			return true;
		}
		
		return false;
	}
	
	/**
	 * 寻找共同的父节点
	 * 将两个节点的父节点栈进行对比，一次弹出相同的节点，最后一次弹出的相同节点即为最近的公共父节点
	 */
	private static BinNode findParentNode(BinNode root, BinNode node1, BinNode node2){
		
		Stack stack1 = new Stack();
		getPositionByNode(root, node1, stack1);
		
		Stack stack2 = new Stack();
		getPositionByNode(root, node2, stack2);
		
		BinNode tempNode = null;
		while( stack1.peek() == stack2.peek() ){
			tempNode = (BinNode) stack1.pop();
			stack2.pop();
		}
		return tempNode;
	}
	
	
	//测试
	public static void main(String[] args) {
		
		BinNode temp = findParentNode(Common.root, Common.leftLeft, Common.right);
		
		System.out.println(temp.Element);
				
	}
	
}





