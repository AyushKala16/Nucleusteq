import java.util.*;

public class Anagrams {
    // Method to check if two strings are anagrams
    static boolean areAnagrams(String str1, String str2) {
        // Remove white spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // If lengths are not equal, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to character arrays and sort them
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted arrays
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter first string.");
        String str1 = sc.nextLine();
        
        System.out.println("Enter second string.");
        String str2 = sc.nextLine();

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        }
        else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }
}
