package Shape;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
	private Field field;
	
	public ShapeComparator(Field field){
		this.field=field;
	}
	public enum Field{
		COLOR, AREA;
	}
	
	
	
	@Override
	public  int compare(Shape s1,Shape s2) {
		int result=0;
		switch (field){
		case COLOR:
			result= s1.color.toUpperCase().compareTo(s2.color.toUpperCase()) ;
			break;
		case AREA:
			result = s1.area<s2.area ? -1:
				s1.area>s2.area?1:0;
				break;
		}
		return result;
	}

}
