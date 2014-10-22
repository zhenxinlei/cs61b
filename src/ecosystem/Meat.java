package ecosystem;

public class Meat implements Food {
	

	@Override
	public synchronized String  getFoodName(Food food)  {
		return this.toString();
		
	}
	public String toString(){
		return "Meat";
	}
	@Override
	public boolean isCarnivoreFood() {
		
		return true;
	}
	@Override
	public boolean isHerbivoreFood() {
		
		return false;
	}
	

}
