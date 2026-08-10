abstract class Payment{
	abstract void makePayment(double amount);
}
class CreditCard extends Payment{
	void makePayment(double amount){
		System.out.println("Credit Card Payment: "+amount);
	}
}
class UPI extends Payment{
	void makePayment(double amount){
		System.out.println("UPI Payment: "+amount);
	}
}
public class PaymentSystem{
	public static void main(String[] args){
		Payment creditCard=new CreditCard();
		Payment upi=new UPI();
		creditCard.makePayment(5000);
		upi.makePayment(2500);
	}
}

