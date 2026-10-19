import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calculator = (Calculator)
            registry.lookup("CalculatorService");
            System.out.print("Enter first number: ");
            double a = sc.nextDouble();
            System.out.print("Enter second number: ");
            double b = sc.nextDouble();
            System.out.println("\nChoose operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            double result;
            switch (choice) {
                case 1:
                    result = calculator.add(a, b);
                    break;
                case 2:
                    result = calculator.subtract(a, b);
                    break;
                case 3:
                    result = calculator.multiply(a, b);
                    break;
                case 4:
                    result = calculator.divide(a, b);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
