package Algorithm;

import DataStructures.Node;

public class InsertionSortLinkedList {

	public Node<Integer> insertionSort(Node<Integer> l1,Node<Integer> l2){
		Node<Integer> cur=new Node<Integer>(0);
		
		
		
		while (l1.next!=null &&l2.next!=null){
			
			cur.next= l2.val<l1.val?l2:l1;
		}
		
		
		
		return l1;
	}
	
}
