package ReadWriteLockModel;

public class Main {
	
	public static void main(String[] args) {
		
		StringBuilder doc=new StringBuilder("");
		ReadWriteLock lock=new ReadWriteLock(doc);
		
		lock.readLock();
		
	}

}
