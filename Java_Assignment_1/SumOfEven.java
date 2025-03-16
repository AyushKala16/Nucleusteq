import java.util.*;

public class SumOfEven {

    public static void main(String[] args) {

        int sum=0;
        for (int i = 1; i <= 10; i++) {
            if(i%2==0)
            sum+=i;
        }
        // printing sum of even number from 1 to 10.
        System.out.println("Sum of even numbers from 1 to 10 is: " + sum);
    }
}
