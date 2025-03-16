import java.util.*;

public class CheckPrime {
    
    public static boolean isPrime(int num){
        if(num<=3)
        return true;
        
        for(int i=2;i*i<=num;i++){
            if(num%2==0)
            return false;
        }
        return true;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a positive number.");
        int num = sc.nextInt();
        
        if(isPrime(num)){
            System.out.println(num + " is a prime number");
        }
        else{
            System.out.println(num + " is not a prime number");
        }
    }
}