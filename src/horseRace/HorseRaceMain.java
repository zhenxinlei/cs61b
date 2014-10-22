package horseRace;

public class HorseRaceMain {
	public static void main(String[] args) throws InterruptedException
	{
		Race race=new Race();
		WaterTrough trough= new WaterTrough();
		new Thread(new Horse("A", race,trough)).start();
		new Thread(new Horse("b", race,trough)).start();
		new Thread(new Horse("c", race,trough)).start();
		new Thread(new Horse("d", race,trough)).start();
		new Thread(new Horse("e", race,trough)).start();
		
		System.out.println("Get ready....");
		Thread.sleep(2000);
		System.out.println("Get Set....");
		Thread.sleep(2000);
		System.out.println("GO!");
		race.startRace();
		
	}

}
