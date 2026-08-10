class Account{
	final int accountNumber;
	String holderName;
	double balance;
	Account(int accountNumber,String holderName,double balance){
		this.accountNumber=accountNumber;
		this.holderName=holderName;
		this.balance=balance;
	}
	void display(){
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Account Holder: "+holderName);
		System.out.println("Balance: "+balance);
	}
}
public class BankAccount{
	public static void main(String[] args){
		Account account=new Account(220,"Vyom Mittal",50000);
		account.display();
	}
}



