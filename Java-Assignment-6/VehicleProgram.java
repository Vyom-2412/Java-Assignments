interface Action {
    void performAction();
}
class Vehicle {
    String brand;
    String model;
    Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    class VehicleDetails {
        void displayDetails() {
            System.out.println("Vehicle Brand : " + brand);
            System.out.println("Vehicle Model : " + model);
        }
    }
}
public class VehicleProgram {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Honda", "City");
        Vehicle.VehicleDetails details = vehicle.new VehicleDetails();
        details.displayDetails();
        Action action = new Action() {
            @Override
            public void performAction() {
                System.out.println("Vehicle is starting...");
            }
        };
        action.performAction();
    }
}













