class Student {
    // Attributes
    String name;
    int rollNumber;
    double marks;

    // Constructor to initialize attributes
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
}


public class Main {
    public static void main(String[] args) {
        // Create an object of Student class
        Student student1 = new Student("Ayush Kala",99, 85.5);

        // Display student details
        student1.displayDetails();
    }
}