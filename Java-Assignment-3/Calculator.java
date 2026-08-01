class Calc {
    static int calculationCount = 0;
    int add(int a, int b) {
        calculationCount++;
        return a + b;
    }
    int add(int a, int b, int c) {
        calculationCount++;
        return a + b + c;
    }
    double add(double a, double b) {
        calculationCount++;
        return a + b;
    }
    static void displayCount() {
        System.out.println("Total Calculations Performed: " + calculationCount);
    }
}
public class Calculator {
    public static void main(String[] args) {
        Calc calc = new Calc();
        System.out.println("Addition of Two Integers: " + calc.add(10, 20));
        System.out.println("Addition of Three Integers: " + calc.add(10, 20, 30));
        System.out.println("Addition of Two Double Values: " + calc.add(12.5, 7.8));
        Calc.displayCount();
    }
}




