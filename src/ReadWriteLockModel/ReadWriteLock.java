package ReadWriteLockModel;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.text.Document;

public class ReadWriteLock {
	
	public ReadWriteLock(StringBuilder doc){
		this.doc=doc;
	}
	StringBuilder doc;
	int reader=0;
	int writer=0;
	Queue<DocumentProcess> waitingTasks=new LinkedBlockingQueue<DocumentProcess>();
	Thread lockingThread=null;
	
	public void readLock(){
		
		DocumentProcess readTask=new ReadTask(this.doc);
		boolean isBlockedForCurrentThread=true;
		
		synchronized(this){
			waitingTasks.add(readTask);
		}
		
		while(isBlockedForCurrentThread){
			synchronized (this) {
				
			
				isBlockedForCurrentThread=
						writer>0||waitingTasks.peek()!=readTask;
				
				//if can read doc
				if (!isBlockedForCurrentThread){
					//readTask.run();
					reader++;
					waitingTasks.poll();
					
					lockingThread=Thread.currentThread();
					return;
				}
			
			
				try {
					readTask.doWait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
	}
	
public void writeLock(){
		
		DocumentProcess writeTask=new WriteTask(this.doc);
		boolean isBlockedForCurrentThread=true;
		
		synchronized(this){
			waitingTasks.add(writeTask);
		}
		
		while(isBlockedForCurrentThread){
			synchronized (this) {

				isBlockedForCurrentThread=
						reader>0||writer>0||waitingTasks.peek()!=writeTask;
				
				//if can read doc
				if (!isBlockedForCurrentThread){
					//writeTask.run();
					writer++;
					waitingTasks.poll();
					
					lockingThread=Thread.currentThread();
					return;
				}
			
			
				try {
					writeTask.doWait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
	}
	
	public void unlockReadLock(){
		synchronized (this) {
			reader--;
			System.err.println("after unlock read lock, has reader "+reader);
		}
		
		if(waitingTasks.size() > 0){
			waitingTasks.peek().doNotify();
		    }
		
	}
	
	public void unlockWriterLock(){
		synchronized (this) {
			writer--;
			System.err.println("after unlock read lock, has writer "+writer);
		}
		
		if(waitingTasks.size() > 0){
			waitingTasks.peek().doNotify();
		    }
		
	}

	private boolean readerIslocked() {
		
		return writer>0;
	}

}
