package Shape;


public class Rectangle extends Shape{
private double length, width;
public Rectangle (double length,double width){
    this.length=length;
    this.width=width;
    this.area=this.calArea();
}

public Rectangle (){
   
}


public double getLength() {
	return length;
}

public void setLength(double length) {
	this.length = length;
}

public double getWidth() {
	return width;
}

public void setWidth(double width) {
	this.width = width;
}

public double calArea(){
    this.area=width*length;
    return this.area;
}
}
