interface DeliveryStatus {
    void updateStatus();
}
class FoodOrder {
    String customerName;
    String foodItem;
    FoodOrder(String customerName, String foodItem) {
        this.customerName = customerName;
        this.foodItem = foodItem;
    }
    class OrderDetails {
        void displayOrder() {
            System.out.println("Customer Name : " + customerName);
            System.out.println("Food Item     : " + foodItem);
        }
    }
}
public class FoodDelivery {
    public static void main(String[] args) {
        FoodOrder order = new FoodOrder("Vyom Mittal", "Paneer Pizza");
        FoodOrder.OrderDetails details = order.new OrderDetails();
        details.displayOrder();
        DeliveryStatus status = new DeliveryStatus() {
            @Override
            public void updateStatus() {
                System.out.println("Delivery Status : Out for Delivery");
            }
        };
        status.updateStatus();
    }
}


