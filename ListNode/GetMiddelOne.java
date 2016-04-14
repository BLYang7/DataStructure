package com.ListNode;
/**
 * 寻找链表的中间一个节点
 *
 */
public class GetMiddelOne {
	/**
	 * 方法一：两个指针
	 * 使用两个指针，指针一每次走一步，指针二每次走两步
	 * 这里涉及到一个奇偶性的问题，偶数的时候输出中间两个，奇数的时候输出中间一个
	 */
	private static ListNode getMiddleOne(ListNode head, Boolean[] isOdd){
		ListNode A = head;
		ListNode B = head;
		while( B != null && B.next != null && B.next.next != null ){
			A = A.next;
			B = B.next.next;
		}
		
		if( B.next != null ){
			isOdd[0] = true;
		} else {
			isOdd[0] = false;
		}
		
		return A;
	}
	
	//测试
	public static void main(String[] args) {
		Boolean[] isOdd = new Boolean[]{false};
		ListNode node = getMiddleOne(Common.head, isOdd);
		
		if(isOdd[0]){
			System.out.println(node.value);
			System.out.println(node.next.value);
		} else {
			System.out.println(node.value);
		}
	}
}
