public class ExceptionHandlingExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            // Code that throw an exception
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handling exception
            System.out.println("Error: Division by zero is not allowed.");
        }
        System.out.println("Program continues after exception handling...");
    }
}
