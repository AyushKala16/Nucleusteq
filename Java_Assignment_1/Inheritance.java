// Base class
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

// Derived class (GraduateStudent) - Inheriting from Student
class GraduateStudent extends Student {
    // Additional attribute
    String researchTopic;

    // Constructor to initialize both parent and child class attributes
    public GraduateStudent(String name, int rollNumber, double marks, String researchTopic) {
        super(name, rollNumber, marks); // Call parent class constructor
        this.researchTopic = researchTopic;
    }

    // Overriding method to display graduate student details
    public void displayDetails() {
        super.displayDetails(); // Call parent class method
        System.out.println("Research Topic: " + researchTopic);
    }
}


public class Inheritance {
    public static void main(String[] args) {
        // Create an object of GraduateStudent class
        GraduateStudent gradStudent = new GraduateStudent("Ayush Kala", 101, 88.5, "Machine Learning");

        // Display details of the graduate student
        gradStudent.displayDetails();
    }
}