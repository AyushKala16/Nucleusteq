import java.util.*;

public class OperatorsDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // Arithmetic Operators
        System.out.println("\n--- Arithmetic Operators ---");
        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction: " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));
        System.out.println("Division: " + (num1 / num2));
        System.out.println("Modulus: " + (num1 % num2));

        // Relational Operators
        System.out.println("\n--- Relational Operators ---");
        System.out.println(num1 + " == " + num2 + " : " + (num1 == num2));
        System.out.println(num1 + " != " + num2 + " : " + (num1 != num2));
        System.out.println(num1 + " > " + num2 + " : " + (num1 > num2));
        System.out.println(num1 + " < " + num2 + " : " + (num1 < num2));
        System.out.println(num1 + " >= " + num2 + " : " + (num1 >= num2));
        System.out.println(num1 + " <= " + num2 + " : " + (num1 <= num2));

        // Logical Operators
        System.out.println("\n--- Logical Operators ---");
        boolean condition1 = (num1 > 0);
        boolean condition2 = (num2 > 0);

        System.out.println("num1 > 0 AND num2 > 0 : " + (condition1 && condition2));
        System.out.println("num1 > 0 OR num2 > 0 : " + (condition1 || condition2));
        System.out.println("NOT num1 > 0 : " + (!condition1));

    }
}
