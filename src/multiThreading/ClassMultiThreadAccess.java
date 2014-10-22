package multiThreading;

public class ClassMultiThreadAccess {
	
	private Object lock=new Object();
	
	public synchronized  void synMethod(String name) throws InterruptedException{
		System.out.println(name+" synMethod");
		this.wait(10000);
	}
	
	public void lockMethod(String name) throws InterruptedException{
		synchronized (lock){
			System.out.println(name +" lockMethod");
			this.wait(10000);
		}
	}
	
	public synchronized void getReadyToRace(String name) throws InterruptedException{
		this.wait();
		System.out.println(name +" getReadyToRace");
	}
	
	//thread was in wait state, when notifyall become runnable 
	public synchronized void startRace(){
		this.notifyAll();
	}

	

}
