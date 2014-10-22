package Shape;

public class ShapeFactory {
	private Shape shape;
	
	public Shape getInstance(String shape){
		if (shape==null){
			return null;
		}
		if (shape.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		}
		if (shape.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		}
		if (shape.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
		
		return null;
	}
	
}
