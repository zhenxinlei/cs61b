package Shape;

public class Square extends Shape{
    private double length;
    public Square (double length){
        this.length=length;
        this.area=this.calArea();
  
    }
    public Square (){
      
  
    }
    public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}


    public double calArea(){
        this.area=length*length;
        return this.area;
    }
}