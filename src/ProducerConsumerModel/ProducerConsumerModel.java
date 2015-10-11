package ProducerConsumerModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerModel {
	BlockingQueue<String> q=new LinkedBlockingQueue<String>(2);
	
	public static void main(String[] args) {
		ProducerConsumerModel pcm=new ProducerConsumerModel();
		
		Thread p=new Thread(new Producer(pcm.q));
		Thread c=new Thread(new Consumer(pcm.q));
		
		p.start();
		c.start();
		
		//System.exit(0);
	}

}
