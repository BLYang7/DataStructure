package com.BinNode;

public class Common {

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
	
}
