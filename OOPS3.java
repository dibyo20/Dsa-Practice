public class OOPS3 {
    public static void main(String args[]){
        Horse h = new Horse();
        h.eat();       // Inherited from Animal class
        h.walk();      // Implemented in Horse class
        System.out.println("Horse color: " + h.color); // Default color
        h.changecolor(); // Change color of horse

        chicken c = new chicken();
        c.eat();       // Inherited from Animal class
        c.walk();      // Implemented in chicken class

        // Animal a = new Animal();    // Cannot instantiate abstract class Animal
    }

    static abstract class Animal {
        String color;

        Animal(){
            color = "brown";  // Default color
        }

        void eat() {
            System.out.println("Eating...");
        }

        abstract void walk();
    }

    static class Horse extends Animal {    // Neccessary to implement abstract method i.e. walk()
        void changecolor(){
            color = "black";  
            System.out.println("Horse color: " + color);
        }

        void walk() {
            System.out.println("Walking on 4 legs...");
        }
    }

    static class chicken extends Animal {  // Neccessary to implement abstract method i.e. walk()
        void changecolor(){
            color = "white";  
            System.out.println("Chicken color: " + color);
        }

        void walk() {
            System.out.println("Walking on 2 legs...");
        }
    }
}
