class Student {
    // Private attributes (data hiding)
    private String name;
    private int rollNumber;
    private double marks;

    // Setting Parameters
    public void Setter(String name,int rollNumber, double marks){
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    
    
    // Getting parameters
    public void Getter(){
        System.out.println("Name: " + name);
        System.out.println("RollNumber: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
}


public class Encapsulation {
    public static void main(String[] args) {
        // Create an object of Student class
        Student student = new Student();

        student.Setter("Ayush Kala",101,89.5);
        student.Getter();
    }
}