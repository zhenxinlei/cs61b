package Algorithm;

import DataStructures.Node;

public class AddTwoNumbers {
	public Node solution(Node<Integer> n1,Node<Integer> n2){
		
		Node<Integer> sum=new Node<Integer>(0);
		Node<Integer> head=sum;
		if (n1==null&&n2==null){ return null;}
		else if (n1==null){return n2;}
		else if (n2==null) {return n1;}
		
		Integer temp=0;
		while (n1!=null ||n2!=null){
			if (sum.next==null){sum.next=new Node<Integer>(0);sum=sum.next;}
			if (n1==null){
				n1=new Node<Integer>(0);
			}
			if (n2==null){
				n2=new Node<Integer>(0);
			}
			//sum=new Node<Integer>(0);
			temp= n1.val+n2.val;
			if (temp/10>=1){
				if (n1.next==null){
					n1.next=new Node<Integer>(0);
				}
				n1.next.val=(Integer)n1.next.val+Integer.valueOf(1);
				if (n2.next==null){
					n2.next=new Node<Integer>(0);
				}
				sum.val=temp%10;
			}
			else {
				sum.val=temp;
			}
			
			n1=n1.next;
			n2=n2.next;
			//sum=sum.next;
		}
		
		
		return head.next;
	}
	
	public static void main (String[]arg){
		
		AddTwoNumbers atn=new AddTwoNumbers();
		Node<Integer> n1=new Node<Integer>(3);
		Node<Integer> n2=new Node<Integer>(0);
		
		n1.next=new Node<Integer>(7);
		
		
		
		
		//reverse linked list
		Node<Integer> c=atn.solution(n1, n2);
		
		Node<Integer> p=null;
		Node<Integer> rh;
		if (c==null||c.next==null) {;}
		else {
		
		Node<Integer> n=c.next;

		while (c!=null){
			n=c.next;
			c.next=p;
			p=c;
			c=n; 
			
		}
		}
		rh=p;
		
		//print reversed linklist
		while (rh!=null){
			System.err.print(rh.val);
			rh=rh.next;
		}
	}

}
