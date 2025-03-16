import java.util.*;

public class ArrayAverage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        // Create an array of the given size
        int[] arr = new int[size];
        int sum = 0;

        // Input array elements
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        // Calculate average
        double average = (double) sum / size;

        System.out.printf("Average of the elements: %.2f", average);

    }
}
