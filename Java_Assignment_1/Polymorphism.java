// Base class
class Animal {
    // Method with one parameter (method overloading in parent class)
    void sound(String animalType) {
        System.out.println(animalType + " makes a sound.");
    }
    
    // Method without parameters
    void sound() {
        System.out.println("Animal makes a sound.");
    }
}

// Derived class (Dog) - Overriding parent method
class Dog extends Animal {

    // Overriding the sound method from parent class
    @Override
    void sound() {
        System.out.println("Dog barks.");
    }

    // Overloading the sound method (with parameters)
    void sound(String breed, int age) {
        System.out.println("The " + breed + " dog, age " + age + ", barks loudly.");
    }
}


public class Polymorphism {
    public static void main(String[] args) {
        // Parent class reference pointing to parent object
        Animal animal = new Animal();
        animal.sound(); // Calls Animal's sound()
        animal.sound("Cat"); // Calls Animal's overloaded method

        // Child class object
        Dog dog = new Dog();
        dog.sound(); // Calls Dog's overridden sound()
        dog.sound("Labrador", 3); // Calls Dog's overloaded sound()
    }
}