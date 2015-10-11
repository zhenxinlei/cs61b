package Algorithm;

import DataStructures.Node;

public class ReverseLinkedListII {
		
		   public  Node<Integer> reverseBetween(Node<Integer> head, int m, int n) {
		        if (head==null||head.next==null) return head;
		        int count =1;
		        Node<Integer> c=head;
		        Node<Integer> pre=new Node<Integer>(0);
		        while (count++<m){
		        	pre=c;
		            c=c.next;
		        }
		        count--;
		        Node<Integer> rp=c;
		        Node<Integer> r=null;
		        Node<Integer> next;
		        while(c!=null && count++<=n){
		            next=c.next;
		            c.next=r;
		            r=c;
		            c=next;
		        }
		        
		        pre.next=r;
		        rp.next=c;
		        
		        return m==1? pre.next: head;
		        
		        
		    }
		   
		   public static void main (String [] arg){
			   ReverseLinkedListII rl=new ReverseLinkedListII();
			   Node<Integer> n1=new Node<Integer>(1);
			   Node<Integer> n2=new Node<Integer>(2);
			   Node<Integer> n3=new Node<Integer>(3);
			   Node<Integer> n4=new Node<Integer>(4);
			   Node<Integer> n5=new Node<Integer>(5);
			   Node<Integer> n6=new Node<Integer>(6);
			   
			   n1.next=n2;
			   n2.next=n3;
			   n3.next=n4;
			   n4.next=n5;
			   n5.next=n6;
			  // System.err.println();
			   Node<Integer> head=rl.reverseBetween(n1, 1, 4);
			   while (head!=null){
				   System.err.println(head.val);
				   head=head.next;
			   }
			   
			   
		   }
		
	
}
