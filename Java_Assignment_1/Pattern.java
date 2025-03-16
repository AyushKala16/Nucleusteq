import java.util.*;

public class Pattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Select Pattern");
        System.out.println("1. Triangle");
        System.out.println("2. Square");
        int flag=sc.nextInt();
        
        if(flag==1){
            System.out.print("Enter the number of rows for the triangle: ");
            int rows = sc.nextInt();
    
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= rows - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= (2 * i - 1); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        else if(flag==2){
            System.out.print("Enter the size of the square: ");
            int size = sc.nextInt();
    
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("invalid Input");
        }
    }
}
