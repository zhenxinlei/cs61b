package horseRace;

public class Race {
	//count each horse cross line 
	private int rank=0;
	
	//called by each horse to line up 
	
	/*make sure hores start same time
	wait()define by OBject lang
	1, lock intance lock 
	2. thread to block other thread
	to unlock , firest be locked(synchronized)*/
	
	public synchronized void getReadyToRace() throws InterruptedException{
		this.wait();
	}
	
	//thread was in wait state, when notifyall become runnable 
	public synchronized void startRace(){
		this.notifyAll();
	}
	
	public synchronized int crossFinishLine(){
		return ++rank;
	}
	

}
