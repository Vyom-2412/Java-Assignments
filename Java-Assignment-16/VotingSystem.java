import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class VotingSystem {
    static void checkEligibility(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("You must be 18 or above to vote.");
        }
        System.out.println("You are eligible to vote.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            checkEligibility(age);
        }
        catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Voting eligibility check completed.");
            sc.close();
        }
    }
}




