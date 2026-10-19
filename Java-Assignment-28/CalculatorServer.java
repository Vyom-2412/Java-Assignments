import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            Calculator calculator = new CalculatorImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalculatorService", calculator);

            System.out.println("Calculator server is running.");
            System.out.println("Waiting for client requests...");
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
