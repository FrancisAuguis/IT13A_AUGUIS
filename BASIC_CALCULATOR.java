package midterm;

import java.util.Scanner;

public class Midterm {

 
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

   
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error! Division by zero.");
            return Double.NaN;
        }
        return a / b;
    }

    
    public static double percentage(double a, double percent) {
        return (a * percent) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

      
        System.out.print("Enter the operation (+, -, *, /, %): ");
        char operation = scanner.next().charAt(0);

        
        double result = 0;

      
        double num2 = 0;
        if (operation != '%') {
            System.out.print("Enter the second number: ");
            num2 = scanner.nextDouble();
        }

        
        if (operation == '+') {
            result = add(num1, num2);
        } else if (operation == '-') {
            result = subtract(num1, num2);
        } else if (operation == '*') {
            result = multiply(num1, num2);
        } else if (operation == '/') {
            result = divide(num1, num2);
        } else if (operation == '%') {
            System.out.print("Enter the percentage value: ");
            double percent = scanner.nextDouble();
            result = percentage(num1, percent);
        } else {
            System.out.println("Invalid operation!");
            return; 
        }

       
        System.out.println("Result: " + result);
    }
}
