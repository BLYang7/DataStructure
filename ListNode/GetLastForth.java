package com.ListNode;
/**
 * 寻找单向链表的倒数第四个
 *
 */
public class GetLastForth {

	/**
	 * 方法一：两个链表指针
	 * 先让第一个走四次，然后让两个同时走
	 * 当第一个走到底的时候，第二个则走到了倒数第四个
	 * 返回第二个
	 */
	private static ListNode getLast4th(ListNode head){
		ListNode A = head;
		ListNode B = head;
		
		for(int i=0; i<4; i++){
			if(A.next == null){
				System.out.println("length less than 4");
			}
			A = A.next;
		}
		
		while( A != null){
			A = A.next;
			B = B.next;
		}
		
		return B;
	}
	
	/**
	 * 方法二：数组方法
	 * 做一个长度为四的数组arr，分别存储4N，4N＋1， 4N＋2， 4N＋3的链表节点
	 * 遍历这个链表，得到最后一个元素arr[i]， 则arr[(i+1)%4]即为倒数第四个元素
	 * @throws Exception 
	 */
	private static ListNode getLast4thFun(ListNode head) throws Exception{
		ListNode curr = head;
		int i=0;
		ListNode[] arr = new ListNode[4];
		while( curr.next != null ){
			arr[i] = curr.next;
			curr = curr.next;
			i = (i+1)%4;
		}
		
		if( arr[i] == null ){
			throw new Exception("length less than 4 ");
		}
		return arr[i];
	}
	
	//测试
	public static void main(String[] args) {
		ListNode getNode = getLast4th(Common.head);
		System.out.println(getNode.value);
		
		try {
			ListNode node = getLast4thFun(Common.head);
			System.out.println(node.value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
