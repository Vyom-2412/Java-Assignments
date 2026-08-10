abstract class Order{
	abstract void calculateBill();
}
class DineInOrder extends Order{
	double amount;
	DineInOrder(double amount){
		this.amount=amount;
	}
	void calculateBill(){
		System.out.println("Dine-In Bill: "+amount);
	}
}
class TakeAwayOrder extends Order{
	double amount;
	TakeAwayOrder(double amount){
		this.amount=amount;
	}
	void calculateBill(){
		System.out.println("Take-Away Bill: "+amount);
	}
}
public class FoodOrder{
	public static void main(String[] args){
		Order dineIn=new DineInOrder(1200);
		Order takeAway=new TakeAwayOrder(850);
		dineIn.calculateBill();
		takeAway.calculateBill();
	}
}