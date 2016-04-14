package com.ListNode;
/**
 * 单链表的反转
 */
public class ReverseListNode {

	/**
	 * 反转链表方法的实现
	 * 方法一
	 */
	private static ListNode Reverse(ListNode head){
		
		ListNode curr = head.next;
		ListNode nextNode = null;
		ListNode nextNextNode = null;
		
		if(curr == null || curr.next == null){
			return head;
		}
		
		/**
		 * 重点是这几条语句，
		 * head是处理的头部不能动它
		 * 记录下三个Node点，交换前两个，依次交换
		 */
		while(curr.next != null){
			nextNode = curr.next;
			nextNextNode = nextNode.next;
			nextNode.next = head.next;
			head.next = nextNode;
			curr.next = nextNextNode;
		}
		
		return head;
	}
	
	/**
	 * 反转链表类的实现方法二
	 * 迭代实现
	 */
	private static ListNode ReverseFun(ListNode head){
		if( head.next == null ){
			return head;
		}
		
		ListNode temp = ReverseFun(head.next);
		head.next.next = head;
		head.next = null;
		return temp;
	}
	
	
	//测试
	public static void main(String[] args) {
		
		ListNode temp = Common.head;
		
		while(temp != null){
			System.out.print(temp.value + "-->");
			temp = temp.next;
		}
		
		System.out.println();
		
		ListNode temp1 = new ListNode(-1);
		temp1.next = Common.head;
		Common.head = Reverse(temp1);
		temp1 = Common.head.next;
		while(temp1 != null){
			System.out.print(temp1.value + "-->");
			temp1 = temp1.next;
		}
		System.out.println();

//		ListNode temp2 = Common.head;
//		temp2 = ReverseFun(temp2);
//		while( temp2 != null ){
//			System.out.print( temp2.value + "-->" );
//			temp2 = temp2.next;
//		}
		
	}
	
}





