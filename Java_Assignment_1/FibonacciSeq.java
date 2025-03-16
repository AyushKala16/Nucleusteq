import java.util.*;

public class FibonacciSeq {

    public static long calculateNthNum(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return calculateNthNum(n - 2) + calculateNthNum(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num <= 0) {
            System.out.println("Invalid Input: Negetive Number");
        } else {
            long fib = calculateNthNum(num);
            System.out.println(num + "th term of fibonacci series is: " + fib);
        }
    }
}
