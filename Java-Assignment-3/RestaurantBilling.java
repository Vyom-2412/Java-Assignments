class Bill {
    static int orderCount = 0;
    double calculateBill(double price) {
        orderCount++;
        return price;
    }
    double calculateBill(double price, int quantity) {
        orderCount++;
        return price * quantity;
    }
    double calculateBill(double price, int quantity, double discount) {
        orderCount++;
        return (price * quantity) - discount;
    }
    static void displayOrders() {
        System.out.println("Total Orders Processed: " + orderCount);
    }
}
public class RestaurantBilling {
    public static void main(String[] args) {
        Bill bill = new Bill();
        System.out.println("Order 1 Bill: Rs." + bill.calculateBill(150));
        System.out.println("Order 2 Bill: Rs." + bill.calculateBill(120, 3));
        System.out.println("Order 3 Bill: Rs." + bill.calculateBill(200, 2, 50));
        Bill.displayOrders();
    }
}


