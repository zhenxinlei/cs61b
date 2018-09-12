package PublisherConsumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Publisher implements Runnable {
	
	private final Queue sharedQ;
    private int maxSize;
    Random rand = new Random();
     
    public Publisher(Queue sharedQ, int maxSize)
    {
        this.sharedQ = sharedQ;
        this.maxSize = maxSize;
    }
	
    //push msg to q 
	@Override
	public void run() {
		while(true){ //keep producing 
			
			synchronized (sharedQ) { // lock q incase of any one reading 
				while(sharedQ.size()==maxSize){  //check size or wait till has space 
					try{
						System.out.println(" q is full, please wait ");
						sharedQ.wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				
				int newInt = rand.nextInt(100);
				System.out.println("publish ing "+String.valueOf(newInt));
				
				sharedQ.add(String.valueOf(newInt));
				sharedQ.notifyAll(); //notify  whom waitin on q 
			}
			
			/*synchronized (this) {
				try {
					wait((long) (1000L*Math.random()));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
			
		}
		
	}
	
	
	static class Consumer implements Runnable {
		
		private final Queue sharedQ;

		public Consumer(Queue sharedQ) {
			this.sharedQ= sharedQ;
		}

		@Override
		public void run() {
			while (true){ // keep try reading 
				synchronized (sharedQ) { 
					while(sharedQ.isEmpty()){ //if empty wait 
						try {
							System.out.println("q is empty wait");
							sharedQ.wait();
							
						} catch (InterruptedException e){
							e.printStackTrace();
						}
					}
					
					String msg = (String) sharedQ.poll();
					System.out.println(" read from q "+ msg);
					sharedQ.notifyAll(); //notify  whom waitin on q 
				}
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
        
        
        final Queue sharedQ = new LinkedList < String >();
         
        Thread consumerThread = new Thread(new Publisher.Consumer(sharedQ), "CONSUMER");
        Thread producerThread = new Thread(new Publisher(sharedQ, 100), "PRODUCER");
         
        producerThread.start();
        consumerThread.start();
         
         
    }

}




