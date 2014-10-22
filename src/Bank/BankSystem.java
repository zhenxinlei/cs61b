package Bank;

import horseRace.Horse;
import horseRace.Race;
import horseRace.WaterTrough;

public class BankSystem {
	public static void main(String[] args) 
	{
		BankAccount bankAccount =new BankAccount (1000);
		//Person father =new Person(bankAccount,500);
		//Person mother =new Person(bankAccount,100);
		
		
		
//		new Thread(father).start();
		
		new Thread(new Person(bankAccount,500)).start();
		
		
		new Thread(new Person(bankAccount,100)).start();
		
/*		Thread fatherThread=new Thread(father);
		fatherThread.setName("Father");
		Thread motherThread=new Thread(mother);
		motherThread.setName("Mother");*/
		
		
		
		//fatherThread.start();
		//motherThread.start();
		
	//	System.out.println("\nmain method account balance: "+bankAccount.getBalance()+"\n");
		
//		try {
//			fatherThread.sleep(2000);
//			System.out.println("father thread sleep");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//fatherThread.run();
		//motherThread.run();
	}

}
