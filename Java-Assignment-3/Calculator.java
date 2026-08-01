class Calculator {
    static String college = "Symbiosis Institute of Technology";
    static void displayCollege() {
        System.out.println("College : " + college);
    }
    int add(int a, int b) {
        return a + b;
    }
    int add(int a, int b, int c) {
        return a + b + c;
    }
    double add(double a, double b) {
        return a + b;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Calculator.displayCollege();
        System.out.println();
        System.out.println("Addition of Two Integers : " + calc.add(10, 20));
        System.out.println("Addition of Three Integers : " + calc.add(10, 20, 30));
        System.out.println("Addition of Two Double Values : " + calc.add(12.5, 7.8));
    }
}



