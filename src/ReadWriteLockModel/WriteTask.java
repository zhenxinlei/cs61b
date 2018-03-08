package ReadWriteLockModel;

import java.math.BigInteger;
import java.security.SecureRandom;

public class WriteTask extends DocumentProcess {

	//StringBuilder doc;
	
	public WriteTask(StringBuilder doc){
		this.doc=doc;
	}
	
	public void run() {
		String temp=new BigInteger(130, new SecureRandom()).toString(32);
		
		System.out.println("Thread: "+Thread.currentThread().getId()+ " writing "+temp);
		System.out.println("doc became: " +doc.append(temp));
		
	}

}
