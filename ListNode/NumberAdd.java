package com.ListNode;
/**
 * 用链表实现大数相加
 *
 */
public class NumberAdd {

    //两个链表相加
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helpler(l1, l2, 0);
    }
    
    //帮助类
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
        
        int sum = l1.value + l2.value + k;
        
        ListNode curr = new ListNode(sum % 10);
        curr.next = helpler(l1.next, l2.next, sum/10);
        return curr;
    }
    
    
    //测试
    public static void main(String[] args) {
		
    	//链表的相加
		ListNode temp = addTwoNumbers(Common.head1 , Common.head2);
		
		//链表的逆序输出
		ListNode sizeCalcu = temp;
		int size = 0;
		while( sizeCalcu != null){
			size++;
			sizeCalcu = sizeCalcu.next;
		}
		ListNode[] arr = new ListNode[size];
		int i=0;
		while(i<size){
			arr[i] = temp;
			temp = temp.next;
			i++;
		}
		for(int j=size; j>0; j--){
			System.out.print(arr[j-1].value);
		}
		
	}
}
