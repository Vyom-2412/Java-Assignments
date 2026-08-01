class Mobile {
    String brand;
    String model;
    double price;
    Mobile() {
        brand = "Samsung";
        model = "Galaxy A16";
        price = 15999;
    }
    Mobile(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    Mobile(Mobile m) {
        brand = m.brand;
        model = m.model;
        price = m.price;
    }
    void display() {
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : ₹" + price);
        System.out.println();
    }
}
public class MobileInventory {
    public static void main(String[] args) {
        Mobile m1 = new Mobile();
        Mobile m2 = new Mobile("Apple", "iPhone 16", 79999);
        Mobile m3 = new Mobile(m2);
        System.out.println("Default Constructor");
        m1.display();
        System.out.println("Parameterized Constructor");
        m2.display();
        System.out.println("Copy Constructor");
        m3.display();
    }
}

