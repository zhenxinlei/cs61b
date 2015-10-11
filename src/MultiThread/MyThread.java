package MultiThread;

import DataStructures.Node;

public class MyThread implements Runnable {

	//private Counter counter;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//run( counter);
		
	}
	
	public void run(Counter counter){
		run();
		function (counter);
	}
	
	public void function(Counter counter){
		counter.val++;
		System.out.println("Counter: "+counter.val);
		function(counter);
		
	}

}
