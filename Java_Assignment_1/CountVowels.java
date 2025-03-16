import java.util.*;

public class CountVowels {
    // Method to count vowels
    static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase(); // Convert to lowercase for easy comparison
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a String.");
        String str = sc.nextLine();
        int vowelCount = countVowels(str);
        System.out.println("Number of vowels in \"" + str + "\": " + vowelCount);
    }
}
