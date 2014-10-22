package Algorithm;



import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReorderList {
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */

	public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow, cur = slow.next;
        if(cur!=null){
            ListNode tmp = cur.next;
            cur.next = null;
            cur = tmp;
        }
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = mid.next;
            mid.next = cur;
            cur = tmp;
        }
        ListNode left = head, right = mid.next;
        while(right!=null){
            mid.next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = mid.next;
        }

    }
	
	    
	   
	    	
	    
}
