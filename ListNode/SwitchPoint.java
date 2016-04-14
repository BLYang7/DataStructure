package com.ListNode;
/**
 * 单链表中交换任意两个节点
 *
 */
public class SwitchPoint {
	
	/**
	 * 交换一个链表中的任意两个节点
	 * @param head 链表头
	 * @param node1 第一个节点
	 * @param node2 第二个节点
	 */
	private static ListNode SwitchNode(ListNode head, ListNode node1, ListNode node2 ){
		if( node1 == node2 || node1.value == node2.value ){
			return head;
		}
		
		ListNode curr = head;
		
		ListNode curr1 = node1;
		ListNode curr2 = node2;
		ListNode pre1 = null;
		ListNode pre2 = null;
		ListNode curr2Next = null;
		
		while( curr != null ){
			if (curr.next == node1 ){
				pre1 = curr;
				curr1 = pre1.next;
			} else if (curr.next == node2) {
				pre2 = curr;
				curr2 = pre2.next;
				curr2Next = curr2.next;
			}
			curr = curr.next;
		}
		
		pre1.next = curr2;
		curr2.next = curr1.next;
		pre2.next = curr1;
		curr1.next = curr2Next;
		
		return head;
	}

	
	//测试
	public static void main(String[] args) {
		ListNode temp = Common.head2;
		while( temp != null ){
			System.out.print(temp.value + "-->");
			temp = temp.next;
		}
		System.out.println();
		
		ListNode node = SwitchNode(Common.head2, Common.second2, Common.forth2);
		while( node != null){
			System.out.print(node.value + "-->");
			node = node.next;
		}
	}
}




