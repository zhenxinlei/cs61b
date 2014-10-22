package Shape;

public class Circle extends Shape{
    private double radius;
    public Circle (double radius){
        this.radius=radius;
        this.area=this.calArea();
    }
    public Circle (){
        
    }
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}


	public double calArea(){
        this.area=Math.PI*radius*radius;
        return this.area;
    }
	
}
