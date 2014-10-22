package ecosystem;

public class Sheep extends Animal implements Food {

	@Override
	public String getFoodName(Food food) {
		
		return food.toString();
	}

	@Override
	public void eat() {
		System.out.println("Feed sheep "+this.getFoodName(this.food));
		if (this.food.isCarnivoreFood()){
			System.out.println("Sheep won't eat "+this.getFoodName(this.food));
		}
		if (this.food.isHerbivoreFood()){
				System.out.println("Sheep will eat "+this.getFoodName(this.food));
		}
	}
	
	public String toString(){
		return "Sheep";
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
