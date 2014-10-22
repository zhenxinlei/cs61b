package horseRace;

import java.util.Random;

public class WaterTrough {
	private Random rand=new Random(System.currentTimeMillis());
	// set one thread will only use access ,
	//insurace lock 
	public synchronized long getDrink() throws InterruptedException
	{
		//take 1-3 sec to drink
		long duration=Math.abs(this.rand.nextLong()%2000)+1000;
		Thread.sleep(duration);
		return duration;

	}
}
