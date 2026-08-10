interface Product{
	void displayProduct();
}
class ProductBase{
	String name;
	double price;
	ProductBase(String name,double price){
		this.name=name;
		this.price=price;
	}
}
class Electronic extends ProductBase implements Product{
	Electronic(String name,double price){
		super(name,price);
	}
	public void displayProduct(){
		System.out.println("Electronic Product: "+name);
		System.out.println("Price: "+price);
	}
}
class Clothing extends ProductBase implements Product{
	Clothing(String name,double price){
		super(name,price);
	}
	public void displayProduct(){
		System.out.println("Clothing Product: "+name);
		System.out.println("Price: "+price);
	}
}
class Grocery extends ProductBase implements Product{
	Grocery(String name,double price){
		super(name,price);
	}
	public void displayProduct(){
		System.out.println("Grocery Product: "+name);
		System.out.println("Price: "+price);
	}
}
public class ECommerceProduct{
	public static void main(String[] args){
		Product electronic=new Electronic("Laptop",65000);
		Product clothing=new Clothing("T-Shirt",1200);
		Product grocery=new Grocery("Rice",800);
		electronic.displayProduct();
		System.out.println();
		clothing.displayProduct();
		System.out.println();
		grocery.displayProduct();
	}
}





