package multiThreading;

public class RunnableClass implements Runnable {
	private String name;
	private ClassMultiThreadAccess cmta;
	public RunnableClass(String name,ClassMultiThreadAccess cmta){
		this.name=name;
		this.cmta=cmta;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			cmta.getReadyToRace(this.name);
			System.out.println(this.name+" is off and running");
			System.out.println("running in run method");
			
			cmta.lockMethod(name);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("InterruptedException in run method");
			e.printStackTrace();
		}
		
	}
	
	

}
