package com.BinNode;
/**
 * 实现一个二叉树
 *
 */
public class BinNode {
	
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
