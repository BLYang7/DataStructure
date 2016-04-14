package com.ListNode;
/**
 * 合并两个有序链表
 *
 */
public class MergeTwoList {

	private static ListNode Merge(ListNode head1, ListNode head2){
		ListNode head = new ListNode(-1);  //记录下首部
		ListNode pre = head;  //用来做迭代用
		ListNode curr;  //临时变量
		
		ListNode curr1 = head1;
		ListNode curr2 = head2;
		
		//比较链表，较小的添加到新的链表里
		while( curr1 != null && curr2 != null){
			
			if( curr1.value < curr2.value ){
				curr = new ListNode( curr1.value );
				curr1 = curr1.next;
			} else if(curr1.value > curr2.value) {
				curr = new ListNode( curr2.value );
				curr2 = curr2.next;
			} else {
				curr = new ListNode(curr1.value);
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			
			pre.next = curr;
			pre = pre.next;
		}
		
		if( curr1 != null ){
			pre.next = curr1;
		} else if( curr2 != null ){
			pre.next = curr2;
		}
		
		return head;
	}
	
	//测试 
	public static void main(String[] args) {
		ListNode node = Merge(Common.head, Common.head1).next;
		while( node != null ){
			System.out.print(node.value + "-->");
			node = node.next;
		}
	}
	
}
