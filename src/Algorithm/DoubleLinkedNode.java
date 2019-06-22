package Algorithm;

public class DoubleLinkedNode {
	int val, key;
	      DoubleLinkedNode left;
	      DoubleLinkedNode right;
	      DoubleLinkedNode(int key, int val ) { this.key= key; this.val = val; }
	      
	public DoubleLinkedNode generateBTree(){
		DoubleLinkedNode root=new DoubleLinkedNode(-1,(int) Math.round((double)Math.random()*10));
		int i=(int) Math.round((double)Math.random()*10);
		
		return root;
	}
	 
}
