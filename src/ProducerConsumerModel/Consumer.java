package ProducerConsumerModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable {
	final BlockingQueue<String> q ;
	int count=0;
	public Consumer(BlockingQueue<String> linkedBlockingQueue) {
		// TODO Auto-generated constructor stub
		this.q=linkedBlockingQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//if(q.size()==0) System.out.println("Q is empty");
		while (true){
			
		try {
			System.out.println("Consumer consumed "+(count++)+"th "+"product: "+q.take());
			System.out.println("q size "+q.size());
			long time =(long) (Math.random()*1000);
			System.out.println("consumer sleep "+time+" ms.");
			Thread.currentThread().sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			//
		//} //catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		}
	}

}
