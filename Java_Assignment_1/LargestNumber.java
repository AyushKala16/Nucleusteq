import java.util.*;

public class LargestNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input three numbers
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();

        // Find the largest using if-else
        int largest=-1;
        if (num1 >= num2 && num1 >= num3) {
            largest = num1;
        }
        else if (num2 >= num1 && num2 >= num3) {
            largest = num2;
        }
        else {
            largest = num3;
        }

        // Output the largest number
        System.out.println("The largest number is: " + largest);

    }
}
