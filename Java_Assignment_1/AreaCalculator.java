import java.util.*;

public class AreaCalculator {

    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }

    public static double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose the shape to calculate area:");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = sc.nextInt();

        double area = 0;
        switch (choice) {
            case 1:
                System.out.print("Enter the radius of the circle: ");
                double radius = sc.nextDouble();
                area = calculateCircleArea(radius);
                System.out.printf("Area of Circle: %.2f%n", area);
                break;

            case 2:
                System.out.print("Enter the length of the rectangle: ");
                double length = sc.nextDouble();
                System.out.print("Enter the width of the rectangle: ");
                double width = sc.nextDouble();
                area = calculateRectangleArea(length, width);
                System.out.printf("Area of Rectangle: %.2f%n", area);
                break;

            case 3:
                System.out.print("Enter the base of the triangle: ");
                double base = sc.nextDouble();
                System.out.print("Enter the height of the triangle: ");
                double height = sc.nextDouble();
                area = calculateTriangleArea(base, height);
                System.out.printf("Area of Triangle: %.2f%n", area);
                break;

            default:
                System.out.println("Invalid choice");
        }
    }
}
