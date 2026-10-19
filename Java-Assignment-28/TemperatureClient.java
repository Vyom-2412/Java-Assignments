import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class TemperatureClient {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            TemperatureConverter converter = (TemperatureConverter)
            registry.lookup("TemperatureService");
            System.out.println("Temperature Conversion");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            System.out.print("Enter temperature: ");
            double temperature = sc.nextDouble();
            double result;
            switch (choice) {
                case 1:
                    result = converter.celsiusToFahrenheit(temperature);
                    System.out.printf(
                            "Temperature in Fahrenheit: %.2f%n", result);
                    break;
                case 2:
                    result = converter.fahrenheitToCelsius(temperature);
                    System.out.printf(
                            "Temperature in Celsius: %.2f%n", result);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
