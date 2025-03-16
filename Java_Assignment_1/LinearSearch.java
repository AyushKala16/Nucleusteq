import java.util.*;

public class LinearSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        // Input array elements
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter key to search: ");
        int key = sc.nextInt();
        
        int index=-1;
        
        for(int i = 0; i<size; i++){
            if(arr[i]==key){
                index=i;
                break;
            }
        }
        
        // Display result
        if (index != -1) {
            System.out.println("Element " + key + " found at index " + index);
        }
        else {
            System.out.println("Element " + key + " not found in the array");
        }
    }
}
