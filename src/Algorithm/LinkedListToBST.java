package Algorithm;

public class LinkedListToBST {
	
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	    public TreeNode sortedListToBST(ListNode head) {
	        
	        return toBST( head,  null);
	       
	        
	    }
	    
	    public TreeNode toBST(ListNode head, ListNode end){
	        ListNode r =findMiddle(head,end);
	        if (r==null) return null;
	        //System.out.println(r.val);
	        TreeNode root=new TreeNode(r.val);
	        
	        root.left= head==r?null:toBST(head, r);
	        
	         //root.left=toBST(head, r);
	         root.right= r.next==end ?null:toBST(r.next,end);
	         
	         return root;
	    }
	    
	    public ListNode findMiddle(ListNode head, ListNode end){
	        if (head==null) return null;
	        if (head.next==null) return head;
	        
	        ListNode mid=head; 
	        ListNode last=head;
	        
	        while (last!=end&&last.next!=end){
	            mid=mid.next;
	            last=last.next.next;
	        }
	        
	        return  mid;
	        
	    }
	    
	    public static void main(String[] args) {
			ListNode l1=new ListNode(1);
			l1.next=new ListNode(3);
			
			LinkedListToBST ltb=new LinkedListToBST();
			ltb.sortedListToBST(l1);
		}
	

}
