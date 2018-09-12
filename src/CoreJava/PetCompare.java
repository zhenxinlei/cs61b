package CoreJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PetCompare {

	static class Pet implements Comparable{

		int m_id;
		String m_petType;
		public Pet(String type, int id) {
			this.m_petType=type;
			this.m_id = id;
		}
		
		@Override
		public int compareTo(Object o) {
			Pet another = (Pet) o;
			
			return this.m_petType.compareTo(another.m_petType);
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "type "+this.m_petType+" id "+this.m_id;
		}
		
		
		@Override
		public boolean equals(Object obj) {
			if (obj==null)
				return false;
			if (!(obj instanceof Pet))
				return false;
			
			Pet another = (Pet) obj;
			
			return this.m_id==another.m_id && this.m_petType.equals(another.m_petType);
			
			
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}
	}
	
	
	static class PetComparator implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			int result =0;
			Pet p1 =(Pet)o1;
			Pet p2 =(Pet)o2;
			
			Integer i1 = p1.m_id;
			
			Integer i2 = p2.m_id;
			return i1.compareTo(i2);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		ArrayList<Pet> pets = new ArrayList<>();
		
		pets.add (new Pet("cat",1));
		pets.add (new Pet("dog",2));
		pets.add (new Pet("ant",3));
		pets.add( new Pet("bird",4));
		
		Collections.sort(pets);
		System.out.println("compare method --> ");
		for (Pet p : pets){
			System.out.println(p);
		}
		
		Collections.sort(pets, new PetComparator());
		System.out.println("comparator method --> ");
		for (Pet p : pets){
			System.out.println(p);
		}
		
		
		
		
	}
}
