class Vehicle{
	String vehicleNumber;
	String vehicleModel;
	Vehicle(String vehicleNumber,String vehicleModel){
		this.vehicleNumber=vehicleNumber;
		this.vehicleModel=vehicleModel;
	}
	void displayVehicle(){
		System.out.println("Vehicle Number: "+vehicleNumber);
		System.out.println("Vehicle Model: "+vehicleModel);
	}
}
class CarInsurance extends Vehicle{
	double premium;
	CarInsurance(String vehicleNumber,String vehicleModel,double premium){
		super(vehicleNumber,vehicleModel);
		this.premium=premium;
	}
	void displayInsurance(){
		super.displayVehicle();
		System.out.println("Insurance Premium: "+premium);
	}
}
public class VehicleInsurance{
	public static void main(String[] args){
		CarInsurance insurance=new CarInsurance("MH12AB1234","Honda City",15000);
		System.out.println("Vehicle Insurance Details");
		insurance.displayInsurance();
	}
}




