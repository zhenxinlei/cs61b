package ecosystem;

public class Lion extends Animal  {
	
	public void eat(){
		System.out.println("Feed Lions "+this.getFoodName(this.food));
		if (this.food.isCarnivoreFood()){
		System.out.println("Lions will eat "+this.getFoodName(this.food));
		}
		if (this.food.isHerbivoreFood()){
			System.out.println("Lions won't eat "+this.getFoodName(this.food));
		}
	}

	@Override
	public String getFoodName(Food food) {
		
		return food.toString();
	}

	public String toString(){
		return "Lion";
	}

}
