package horseRace;

import java.util.Random;

//each horse is a thread, a race is process 
public class Horse implements Runnable{

	private String name;
	private Race race;
	private WaterTrough trough;
	private Random rand=new Random(System.currentTimeMillis());
	
	
	
	public Horse(String name, Race race, WaterTrough trough){
		this.name=name;
		this.race=race;
		this.trough=trough;
		
	}
	
	//horse run time 2-6 sec , 4-6 sec to get a drink??
	
	public long runlap() throws InterruptedException{
		long duration=Math.abs(this.rand.nextLong())%4000+2000;
		//Thread.sleep(duration);
		return duration;
				
	}
	
	public void run(){
	try{	
		this.race.getReadyToRace();
		System.out.println(this.name+" is off and running");
		//run three laps
		for (int i=1;i<=3; i++){
			long time =this.runlap();
			System.out.println(name+" complete lap "+i +" in "+(double)time/(double)1000.0+" sec.");
			
			time=this.trough.getDrink();
			System.out.println(name+" drinks for  "+(double)time/(double)1000.0 +" sec.");
			
		}
	
	
	//race finish
	int place=this.race.crossFinishLine();
	System.out.println(">>> "+name+ " finishes in position "+ place+ "! <<<");
	}
	catch (InterruptedException ie){
		System.out.println(name+ " apparetly broke a leg and wont be finishing the race");	
	}
	}
}
