package ecosystem;

public class Grass implements Food{

	@Override
	public String getFoodName(Food food) {
		// TODO Auto-generated method stub
		return food.toString();
	}
	
	public String toString(){
		return "Grass";
	}

	@Override
	public boolean isCarnivoreFood() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHerbivoreFood() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
