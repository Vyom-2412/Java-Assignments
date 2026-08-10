class Shape{
	double area(){
		return 0;
	}
}
class Circle extends Shape{
	double radius;
	Circle(double radius){
		this.radius=radius;
	}
	double area(){
		return Math.PI*radius*radius;
	}
}
class Rectangle extends Shape{
	double length;
	double width;
	Rectangle(double length,double width){
		this.length=length;
		this.width=width;
	}
	double area(){
		return length*width;
	}
}
public class ShapeApplication{
	public static void main(String[] args){
		Circle c=new Circle(5);
		Rectangle r=new Rectangle(10,6);
		System.out.println("Circle Area: "+c.area());
		System.out.println("Rectangle Area: "+r.area());
	}
}







