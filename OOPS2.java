public class OOPS2 {
    public static void main(String args[]){
        // Fish shark = new Fish();
        // shark.eat(); // Inherited from Animal

        // Dog dog = new Dog();
        // dog.eat(); // Inherited from Animal
        // dog.walk(); // Inherited from Mammals

        // Calulator calc = new Calulator();
        // System.out.println(calc.sum(5, 10));             // Calls int sum(int a, int b)
        // System.out.println(calc.sum(5.5f, 10.5f));       // Calls float sum(float a, float b)
        // System.out.println(calc.sum(5, 10, 15));       // Calls int sum(int a, int b, int c)

        Deer deer = new Deer();
        deer.eat(); // Example of method overriding
    }

    static class Animal2{       // Base class
        void eat(){
            System.out.println("Eating...");
        }
    }

    static class Deer extends Animal2{     // Inherits from Animal2 and examples method overriding
        void eat(){
            System.out.println("Deer is eating grass...");
        }
    }

    // static class Calulator{     // Example of method overloading
    //     int sum(int a, int b){
    //         return a + b;
    //     }

    //     float sum(float a, float b){
    //         return a + b;
    //     }

    //     int sum(int a, int b, int c){
    //         return a + b + c;
    //     }
    // }

    // static class Animal{    // Base class
    //     String color;

    //     void eat(){
    //         System.out.println("Eating...");
    //     }

    //     void breathe(){
    //         System.out.println("Breathing...");
    //     }
    // }

    // static class Mammals extends Animal{    // Derived class
    //     int legs;

    //     void walk(){
    //         System.out.println("Walking...");
    //     }
    // }

    // static class Bird extends Animal{      // Derived class
    //     int wings;

    //     void fly(){
    //         System.out.println("Flying...");
    //     }
    // } 

    // static class Dog extends Mammals{      // Derived class
    //     String breed;

    //     void bark(){
    //         System.out.println("Barking...");
    //     }
    // }

    // static class Fish extends Animal{     // Derived class
    //     int fins;

    //     void swim(){
    //         System.out.println("Swimming...");
    //     }
    // }
}
