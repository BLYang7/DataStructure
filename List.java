package com.algorithm;

import java.util.ArrayList;
import java.util.Stack;

import com.ListNode.Common;
import com.ListNode.ListNode;

/**
 * 链表类的操作
 * 包含：
 * 		链表创建、
 * 		插入节点、
 * 		删除节点、
 * 		查找节点
 * 		判断是否为空、
 * 		判断是否为尾、
 * 		链表排序
 * 		链表合并、
 * 		链表反转、
 * 		获取最后四个、
 * 		获取中间节点、
 * 		交换节点
 * 		链表相加、
 * 		链表相乘
 */
public class List {

	/**
	 * 链表类
	 */
	private static class ListNode{
		public int element;
		public ListNode next;
		public ListNode(int element){
			this.element = element;
		}
	}
	
	//测试实例
	public static ListNode head = new ListNode( 6 );
	private static ListNode second = new ListNode( 1 );
	public static ListNode third = new ListNode( 2 );
	private static ListNode forth = new ListNode( 5 );
	private static ListNode fivth = new ListNode( 4 );
	private static ListNode sixth = new ListNode( 3 );
	
	public static ListNode head1 = new ListNode( 0 );
	private static ListNode second1 = new ListNode( 6 );
	private static ListNode third1 = new ListNode( 7 );
	private static ListNode forth1 = new ListNode( 8 );
	private static ListNode fivth1 = new ListNode( 9 );
	private static ListNode sixth1 = new ListNode( 7 );
	
	public static ListNode head2 = new ListNode( 1 );
	public static ListNode second2 = new ListNode( 1 );
	private static ListNode third2 = new ListNode( 7 );
	public static ListNode forth2 = new ListNode( 8 );
	private static ListNode fivth2 = new ListNode( 9 );
	private static ListNode sixth2 = new ListNode( 7 );
	
	static {
		head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fivth;
		fivth.next = sixth;
		
		head1.next = second1;
		second1.next = third1;
//		third1.next = forth1;
//		forth1.next = fivth1;
//		fivth1.next = sixth1;
		
		head2.next = second2;
//		second2.next = third2;
//		third2.next = forth2;
//		forth2.next = fivth2;
//		fivth2.next = sixth2;
	}
	
	/**
	 * 判断链表是否为空
	 * @param head 链表头节点
	 * @return 
	 */
	private boolean isEmpty(ListNode head){
		return head.next == null;
	}
	
	/**
	 * 判断是否是尾节点
	 * @param node 待判断节点
	 * @return
	 */
	private boolean isLast(ListNode node){
		return node.next == null;
	}
	
	/**
	 * 链表元素查找
	 * @param element 待查找的元素
	 * @param head 待查找的链表首部
	 * @return 链表中符合查找条件的节点
	 */
	private ArrayList<ListNode> find(int element, ListNode head){
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		while( head != null ){
			if( head.element == element ){
				list.add(head);
			}
			head = head.next;
		}
		return list;
	}
	
	/**
	 * 链表元素的删除
	 * @param element 链表中的元素
	 * @param head 链表首部
	 * @return 删除后的链表首部
	 */
	private ListNode delete(int element, ListNode head){
		ListNode temp = new ListNode(0);
		temp.next = head;
		head = temp.next;
		while(temp.next != null ){
			if( temp.next.element == element ){
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
		return head;
	}
	
	
	/**
	 * 链表节点的插入
	 * @param element 待插入的元素
	 * @param position 带插入的位置
	 */
	private void insert(int element, ListNode position){
		ListNode temp = new ListNode(element);
		temp.next = position.next;
		position.next = temp;
	}
	
	/**
	 * 链表的冒泡排序
	 * @param head 待排序链表首部
	 * @return 排序之后的链表首部
	 */
	private ListNode bubbleSort(ListNode head){
		ListNode pre1,pre2;
		int temp;
		for( pre1 = head; pre1.next != null; pre1 = pre1.next){
			for(pre2 = head; pre2.next != null; pre2 = pre2.next){
				if(pre2.element > pre2.next.element){
					temp = pre2.element;
					pre2.element = pre2.next.element;
					pre2.next.element = temp;
				}
			}
		}
		return head;
	}
	
	
	/**
	 * 两个有序单链表的合并
	 * @param head1 第一个有序单链表的首部
	 * @param head2 第二个有序单链表的首部
	 * @return 合并之后的链表
	 */
	private ListNode Merge(ListNode head1, ListNode head2){
		ListNode head = new ListNode(-1);  //记录下首部
		ListNode pre = head;  //用来做迭代用
		ListNode curr;  //临时变量
		
		ListNode curr1 = head1;
		ListNode curr2 = head2;
		
		//比较链表，较小的添加到新的链表里
		//如果两个值同样大，则合并为一个
		while( curr1 != null && curr2 != null){
			
			if( curr1.element < curr2.element ){
				curr = new ListNode( curr1.element );
				curr1 = curr1.next;
			} else if(curr1.element > curr2.element) {
				curr = new ListNode( curr2.element );
				curr2 = curr2.next;
			} else {
				curr = new ListNode(curr1.element);
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
		return head.next;
	}
	
	
	/**
	 * 链表的反转,使用递归来实现
	 * @param head 待反转的链表的首部
	 * @return 反转之后的链表首部
	 */
	private ListNode reverseListNode(ListNode head){
		if( head.next == null ){
			return head;
		}
		ListNode temp = reverseListNode(head.next);
		head.next.next = head;
		head.next = null;
		return temp;
	}
	
	
	
	/**
	 * 获取链表的最后四个
	 * 方法一：两个链表指针
	 * 先让第一个走四次，然后让两个同时走
	 * 当第一个走到底的时候，第二个则走到了倒数第四个
	 * 返回第二个
	 */
	private ListNode getLastFour(ListNode head){
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
	 * 获取链表的最后四个
	 * 方法二：数组方法
	 * 做一个长度为四的数组arr，分别存储4N，4N＋1， 4N＋2， 4N＋3的链表节点
	 * 遍历这个链表，得到最后一个元素arr[i]， 则arr[(i+1)%4]即为倒数第四个元素
	 * @throws Exception 
	 */
	private ListNode getLastFourthFun(ListNode head) throws Exception {
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
	
	
	
	/**
	 * 获取链表的中间节点
	 * 使用两个指针，指针一每次走一步，指针二每次走两步
	 * 这里涉及到一个奇偶性的问题，偶数的时候输出中间两个，奇数的时候输出中间一个
	 */
	private ListNode getMiddleOne(ListNode head, Boolean[] isOdd){
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
	
	
	/**
	 * 交换一个链表中的任意两个节点
	 * @param head 链表头
	 * @param node1 第一个节点
	 * @param node2 第二个节点
	 */
	private ListNode switchNode(ListNode head, ListNode node1, ListNode node2 ){
		if( node1 == node2 || node1.element == node2.element ){
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
	
	
    /**
     * 两个链表相加
     * @param l1 链表1
     * @param l2 链表2
     * @return 相加之后的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helpler(l1, l2, 0);
    }
    //链表相加帮助类
    public static ListNode helpler(ListNode l1, ListNode l2, int k){
        if(l1 == null && l2 == null){
            return k == 0 ? null : new ListNode(k);
        }
        if(l1 == null && l2  != null){
            l1 = new ListNode(0);
        }
        if(l1 != null && l2 == null){
            l2 = new ListNode(0);
        }
        int sum = l1.element + l2.element + k;
        ListNode curr = new ListNode(sum % 10);
        curr.next = helpler(l1.next, l2.next, sum/10);
        return curr;
    }
	
	
    /**
     * 链表的逆序打印，递归实现
     * @param head
     */
    private void reversePrintRec(ListNode head){
    	if( head == null ){
    		return;
    	} else {
    		reversePrintRec( head.next );
    		System.out.print( head.element + "-->" );
    	}
    }
    
    
    /**
     * 链表的逆序打印，栈
     * @param head
     */
    private void reversePrintStack(ListNode head){
    	Stack<ListNode> stack = new Stack<ListNode>();
    	while( head != null ){
    		stack.push(head);
    		head = head.next;
    	}
    	while(!stack.isEmpty()){
    		System.out.print(stack.pop().element + "-->");
    	}
    }
    
    
    /**
     * 链表相乘
     * @param l1 链表一
     * @param l2 链表二
     * @return 相乘之后的链表
     */
    public ListNode multiply(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return null;
        }
        
        ListNode head = new ListNode(0);
        ListNode res = head;
        ListNode result = new ListNode(0);
        while( l2 != null ){
        	result = addTwoNumbers(result, multiplyHelpler(l1, l2));
        	l2 = l2.next;
        	head.next = result;
        	result = result.next;
        	head = head.next;
        }
        return res.next;
    }
    
    //链表相乘帮助类
    public static ListNode multiplyHelpler(ListNode l1, ListNode l2){

    	ListNode l1Tem = l1;
    	ListNode result = new ListNode(0);
    	ListNode res = result;
        while( l1Tem != null ){
        	int temp = l1Tem.element * l2.element + result.element;
        	result.element = temp % 10;
        	int key = temp / 10;
        	l1Tem = l1Tem.next;
        	if( l1Tem != null){
        		result.next = new ListNode(key);
        	}
        	result = result.next;
        }
        return res;
    }
    
    
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		
		List list = new List();

//		//链表节点的删除
//		head = list.delete(4, head);
//		while( head != null){
//			System.out.print(head.element + "-->");
//			head = head.next;
//		}
		
		
//		//链表节点插入
//		list.insert(8, third);
//		while(head != null){
//			System.out.print(head.element + "-->");
//			head = head.next;
//		}
		
		
//		//链表的冒泡排序
//		head = list.bubbleSort(head);
//		while(head != null){
//			System.out.print(head.element + "-->");
//			head = head.next;
//		}
		
		
//		//两个有序链表的合并
//		ListNode temp = list.Merge(head1, head2);
//		while(temp != null){
//			System.out.print( temp.element + "-->");
//			temp = temp.next;
//		}
		
		
//		//反转链表
//		ListNode temp = list.reverseListNode(head);
//		while(temp != null){
//			System.out.print( temp.element + "-->" );
//			temp = temp.next;
//		}
		
		
//		//获取链表的最后四个
//		ListNode temp = list.getLastFour(head);
//		while(temp != null){
//			System.out.print( temp.element + "-->" );
//			temp = temp.next;
//		}
		
//		//获取链表的最后四个
//		ListNode temp = list.getLastFour(head);
//		while(temp != null){
//			System.out.print( temp.element + "-->" );
//			temp = temp.next;
//		}
		
//		ListNode temp = list.getLastFour(head);
//		while(temp != null){
//			System.out.print( temp.element + "-->" );
//			temp = temp.next;
//		}
		
		
//		//获取链表的中间节点
//		Boolean[] isOdd = new Boolean[]{false};
//		ListNode node = list.getMiddleOne(head, isOdd);
//		if(isOdd[0]){
//			System.out.println(node.element);
//			System.out.println(node.next.element);
//		} else {
//			System.out.println(node.element);
//		}
		
		
//		//交换链表中的任意两个元素
//		ListNode temp = head2;
//		while( temp != null ){
//			System.out.print(temp.element + "-->");
//			temp = temp.next;
//		}
//		System.out.println();
//		ListNode node = list.switchNode(head2, second2, forth2);
//		while( node != null){
//			System.out.print(node.element + "-->");
//			node = node.next;
//		}
		
//		// 两个链表相加
//		ListNode temp = list.addTwoNumbers(head1, head2);
//		while( temp != null ){
//			System.out.print( temp.element + "-->");
//			temp = temp.next;
//		}
		
//		//链表的逆序打印
//		list.reversePrintRec(head);
//		list.reversePrintStack(head);
		
		
//		//链表相乘
//		ListNode temp = list.multiply(head1, head2);
//		while(temp != null){
//			System.out.print(temp.element + "-->");
//			temp = temp.next;
//		}
		
	}
	
	
	
}


















