package ProducerConsumerModel;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable{
	final BlockingQueue<String> q ;
	public Producer(BlockingQueue<String> q2) {
		// TODO Auto-generated constructor stub
		this.q=q2;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i<100; i++){
		String str= generateProduct();
		System.out.println("product generated the "+i+"th"+" Product: "+str);
		
		try {
			long time =(long) (Math.random()*1000);
			System.out.println("producer sleep "+time+" ms.");
			
			Thread.currentThread().sleep(time);
			//sleep((int)Math.random()*10000);
			q.put(str);
			
			System.out.println("q size "+q.size());
			//if(q.) System.out.println("Q is empty");
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		
	}
	
	private String generateProduct() {
		String product= new BigInteger(13, new SecureRandom()).toString(32).toUpperCase();
		return product;
	}
	
	public static void main(String[] args) {
		Producer p=new Producer(new LinkedBlockingQueue<String>());
		
		System.err.println(p.generateProduct());
		
	}
	
	
}
