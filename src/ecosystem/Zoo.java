package ecosystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/*
 * This is an ecosystem in a zoo. When feeding animals food, animals
 * will eat the food or not based on the animal is carnivore or 
 * herbivore.
 * 
 */
public class Zoo {
	public static void main (String [] arg){
		
		final String herbivore="Herbivore";
		final String carnivore="Carnivore";
		
		List<Animal> animalList=new ArrayList<Animal>();
		animalList.add(new Lion());
		animalList.add(new Sheep());
		
		List <Food> foodList = new CopyOnWriteArrayList<Food>();
		foodList.add((Food) new Sheep());
		foodList.add((Food) new Meat());
		foodList.add((Food) new Grass());
		
		//Animal Dictionary is to write down an animal is carnivore or herbivore
		Map<String, String> animalDict=new HashMap<String,String>();
		animalDict.put("Sheep", herbivore);
		animalDict.put("Lion", carnivore);
		
		Food food;
		Animal animal;
		
		for (int i=0;i<animalList.size();i++){
			Iterator it =foodList.iterator();
			while (it.hasNext()){
				food=(Food) it.next();
				System.out.print("\n");
				animal=animalList.get(i);
				animal.food=food;
				System.out.println(animal.toString()+" is "+animalDict.get(animal.toString()));
				animal.eat();
				
					
			}
		}
		
		
			
	}

}
