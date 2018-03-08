package ReadWriteLockModel;

public class ReadTask extends DocumentProcess {
	
	//StringBuilder doc;
	
	public ReadTask(StringBuilder doc){
		this.doc=doc;
	}
	
	public void run() {
		
		System.out.println("Thread: "+Thread.currentThread().getId()+ " reading "+doc);
		
	}
}
	
	

