public class OOPS {
    
    public static void main(String args[]){
        // Pen p1 = new Pen();              // Creating an object 'p1' of Pen class 
        // // pen() is constructor of Pen class
        // p1.setColor("Blue");            
        // System.out.println( p1.getColor()); 
        // p1.setTip(5);
        // System.out.println( p1.getTip());
        // p1.setColor ("Red");               // Changing the color of p1
        // System.out.println( p1.getColor());

        // bankAccount myAcc = new bankAccount(); // Creating an object 'myAcc' of bankAccount class
        // myAcc.username = "dibyobanerjee";
        // // myAcc.password = "12345";          // This line will cause an error because password is private
        // myAcc.setPassword("12345");

        Student s1 = new Student();                // Default constructor
        s1.name = "Dibyo";
        s1.roll = 101;
        s1.password = "12345";
        s1.marks[0] = 85;
        s1.marks[1] = 90;
        s1.marks[2] = 95;

        Student s2 = new Student(s1);                // Copy constructor
        s2.password = "54321"; 
        s1.marks[2] = 100;             // It will also change s2.marks[2] because marks is a reference type or shallow copy
        
        for(int i = 0; i < 3; i++) {
            System.out.println( s2.marks[i]);
        }
    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[];

    Student(){                           // Default constructor or no-parametrized constructor
        System.out.println("Constructor is called...");
        marks = new int[3]; 
    } 

    // Student(Student s1){              // Shallow Copy constructor
    //     marks = new int[3]; 
    //     this.marks = s1.marks;        // This will cause shallow copy, meaning marks will point to the same array as s1.marks
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    // } 

    Student(Student s1){                 // Deep Copy constructor
        marks = new int[3]; 
        this.name = s1.name;
        this.roll = s1.roll; 
        for(int i = 0; i < 3; i++) {     // Copying marks individually to avoid shallow copy
            this.marks[i] = s1.marks[i];   
        }
    }

    Student(String name){                // Parameterized constructor
        this.name = name;
    } 
}

// class bankAccount {
//     public String username;
//     private String password;
//     public void setPassword(String pwd) {
//         password = pwd;
//     }
// }

// class Pen {
//     private String color;
//     private int tip;

//     String getColor(){
//         return this.color;
//     }

//     void setColor(String newcolor){
//         this.color = newcolor;   
//     }

//     void setTip(int tip){
//         this.tip = tip;      // 'this' refers to the current object  
//     }

//     int getTip(){
//         return this.tip;
//     }
// }


