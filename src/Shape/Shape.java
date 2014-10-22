package Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract  class Shape implements Comparable<Shape>{
    protected double area; 
    protected String color;
    
    public abstract  double calArea();
    //public void setArea(double area){
     //   this.area=area;
   // }
    
    public double getArea(){
        return this.area;
    }
    
    public void setColor(String color){
    	this.color=color;
    }
    
    public String getColor(){
    	return this.color;
    }
    
    public int compareTo(Shape s){
        return (int) (this.calArea()-s.calArea());
    }
    

    
    // test
    public static void main (String [] arg){
        List<Shape> shape=new ArrayList();
        Shape c=new Circle(2);
        c.setColor("Red");
        shape.add(c);
        
        Shape r=new Rectangle(2,1);
        r.setColor("green");
        shape.add(r);
        
        
        Shape s=new Square(2);
        s.setColor("blue");    
        shape.add(s);
        
      /*  ShapeFactory sf=new ShapeFactory();
        Circle c= (Circle) sf.getInstance("Circle");
        c.setColor("red");
        c.setRadius(0.1);
        
        Rectangle r=(Rectangle) sf.getInstance("rectangle");
        r.setColor("blue");
        r.setLength(2);
        r.setWidth(4);
        
        shape.add(c);
        shape.add(r);
        */
        
        for (int i=0; i<shape.size(); ++i){
            System.out.println(shape.get(i).toString()+" area: "+shape.get(i).calArea()+" color: "+shape.get(i).getColor());
        }
        
        
        Collections.sort(shape,new ShapeComparator(ShapeComparator.Field.COLOR));
        
        for (int i=0; i<shape.size(); ++i){
            System.out.println(shape.get(i).toString()+" area: "+shape.get(i).calArea()+" color: "+shape.get(i).getColor());
        }
    }
}



