package com.ListNode;
/**
 * 公共类，测试用例都放在这里
 *
 */
public class Common {
	
	public static ListNode head = new ListNode( 0 );
	private static ListNode second = new ListNode( 1 );
	private static ListNode third = new ListNode( 2 );
	private static ListNode forth = new ListNode( 5 );
	private static ListNode fivth = new ListNode( 4 );
	private static ListNode sixth = new ListNode( 3 );
	
	public static ListNode head1 = new ListNode( 0 );
	private static ListNode second1 = new ListNode( 6 );
	private static ListNode third1 = new ListNode( 7 );
	private static ListNode forth1 = new ListNode( 8 );
	private static ListNode fivth1 = new ListNode( 9 );
	private static ListNode sixth1 = new ListNode( 1 );
	
	public static ListNode head2 = new ListNode( 5 );
	public static ListNode second2 = new ListNode( 6 );
	private static ListNode third2 = new ListNode( 7 );
	public static ListNode forth2 = new ListNode( 8 );
	private static ListNode fivth2 = new ListNode( 9 );
	private static ListNode sixth2 = new ListNode( 1 );
	
	static {
		head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fivth;
		fivth.next = sixth;
		
		head1.next = second1;
		second1.next = third1;
		third1.next = forth1;
		forth1.next = fivth1;
		fivth1.next = sixth1;
		
		head2.next = second2;
		second2.next = third2;
		third2.next = forth2;
		forth2.next = fivth2;
		fivth2.next = sixth2;
	}
	
	

	
	

}
