package com.ListNode;
/**
 * 单链表的排序
 *
 */
public class SortList {
	
	private static ListNode SortList(ListNode head){
		ListNode pre1 = head;
		ListNode pre2 = head.next;
		
		ListNode min = null;
		for ( ListNode curr1=head.next; curr1 != null; curr1 = min.next ){
			
			//新的排序
			if( curr1.next == null ){
				break;
			}
			min = curr1;
			
			//查找链表中的最小值
			for( ListNode curr2 = curr1.next; curr2 != null; curr2 = curr2.next ){
				if( curr2.value < curr1.value ){
					min = curr2;
					curr2 = curr1;
					curr1 = min;
					pre1.next = curr1;
					curr2.next = curr1.next;
					curr1.next = pre2;
					if( pre2 != curr2 ){
						pre2.next = curr2;
					}
				}
				pre2 = curr2;
			}
			pre1 = min;
			pre2 = min.next;	
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode temp = SortList(Common.head);
		
		while( temp != null){
			System.out.print( temp.value +"-->");
			temp = temp.next;
		}
		
	}
	
}
