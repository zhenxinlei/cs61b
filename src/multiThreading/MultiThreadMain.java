package multiThreading;


public class MultiThreadMain {
	public static void main (String[] arg) throws InterruptedException{
		ClassMultiThreadAccess cmta=new ClassMultiThreadAccess();
		
		new Thread(new RunnableClass("T1", cmta)).start();
		new Thread(new RunnableClass("t2", cmta)).start();
		new Thread(new RunnableClass("t3", cmta)).start();
		new Thread(new RunnableClass("t4", cmta)).start();
		new Thread(new RunnableClass("t5", cmta)).start();
		new Thread(new RunnableClass("t6", cmta)).start();
		new Thread(new RunnableClass("t7", cmta)).start();
		
		System.out.println("Get ready....");
		Thread.sleep(2000);
		System.out.println("Get Set....");
		Thread.sleep(2000);
		System.out.println("GO!");
		cmta.startRace();
	}

}
