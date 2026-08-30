import java.util.Scanner;

class InvalidLicenseAgeException extends Exception {
    public InvalidLicenseAgeException(String message) {
        super(message);
    }
}
public class DrivingLicense {
    static void checkEligibility(int age) throws InvalidLicenseAgeException {
        if (age < 18) {
            throw new InvalidLicenseAgeException(
                "You must be 18 or above to apply for a driving license."
            );
        }
        System.out.println("You are eligible for a driving license.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            checkEligibility(age);
        }
        catch (InvalidLicenseAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Driving license eligibility check completed.");
            sc.close();
        }
    }
}






