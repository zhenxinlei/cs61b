package Algorithm;

import java.util.Stack;

public class MinStack {
	
	//private  Integer min;
	private Stack<Integer> elementStack;
	private Stack<Integer> minStack;
	
	public MinStack(){
		this.elementStack=new Stack<Integer>();
		this.minStack=new Stack<Integer>();
	}
	
	public void  push(int a){
		elementStack.push(Integer.valueOf(a));
		if (!minStack.isEmpty()){
			if (minStack.peek()>Integer.valueOf(a)){
				minStack.push(Integer.valueOf(a));
			}
			else {
				minStack.push(minStack.peek());
			}
		}
		if (minStack.isEmpty()) minStack.push(Integer.valueOf(a));
		
		
	}
	
	public Integer pop(){
		if (elementStack.isEmpty())return Integer.valueOf(0);
		minStack.pop();
		return elementStack.pop();
		
	}
	
	public Integer getMin(){
		System.out.println("MINStack: "+minStack.peek());
		return minStack.peek();
	}

	
	public static void main (String[] arg ){
		MinStack minstk=new MinStack();
		minstk.pop();
		minstk.push(6);
		minstk.push(3);
		minstk.push(5);
		minstk.pop();
		minstk.push(2);
		minstk.push(2);
		minstk.pop();
		minstk.getMin();
		
	}
}
