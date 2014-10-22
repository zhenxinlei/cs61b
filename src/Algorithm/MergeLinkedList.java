package Algorithm;

import java.util.Stack;

public class MergeLinkedList {
	
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
	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		     }
		 }
	
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode temp;
	        
	        ListNode c1=l1;
	        ListNode c2=l2;
	        
	        if (l1==null && l2==null) return null;
	        if (l1==null ){
	            return l2;
	        }
	        if (l2==null) return l1;
	        
	       Stack<ListNode> s1=new Stack<ListNode>();
	       Stack<ListNode> s2=new Stack<ListNode>();
	       
	       while (c1!=null){
	           s1.push(c1);
	           c1=c1.next;
	       }
	         while (c2!=null){
	           s2.push(c2);
	           c2=c2.next;
	       }
	        
	        ListNode s1pop=new ListNode(0);
	        ListNode s2pop=new ListNode(0);
	        ListNode result=new ListNode(0);
	        while (!s1.isEmpty()&& !s2.isEmpty()){
	            s1pop=s1.peek();
	            s2pop=s2.peek();
	            if (s1pop.val>=s2pop.val){
	                s1pop.next=result;
	                result =s1pop;
	                //s2pop.next=s1pop;
	                s1.pop();
	            }
	            else {
	                s2pop.next=result;
	                result =s2pop;
	               // s1pop.next=s2pop;
	                s2.pop();
	            }
	        }
	        
	        if (s1.isEmpty()){
	            s2.pop().next=result;
	            c2=l2;
	            while (c2.next.next!=null){
	            	//temp=c1.next.next;
	            	c2=c2.next;
	            	
	            }
	            c2.next=null;
	           return l2;
	        }
	        else {
	           s1.pop().next=result;
	           c1=l1;
	            while (c1.next.next!=null){
	            	//temp=c1.next.next;
	            	c1=c1.next;
	            	
	            }
	            c1.next=null;
	           return l1;
	        }
	        
	        
	        
	        
	    }
	    
	    public static void main (String []args){
	    	MergeLinkedList s=new MergeLinkedList();
	    	ListNode l1=s.new ListNode(2);
	    	ListNode l2=s.new ListNode(1);
	    	ListNode result=s.mergeTwoLists(l1,l2);
	    	
	    	while (result!=null){
	    		System.out.println(result.val);
	    		result=result.next;
	    	}
	    	
	    }
}


