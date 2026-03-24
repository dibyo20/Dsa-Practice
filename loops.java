import java.util.*;

public class loops {
    public static void main(String[] args) {

        // // Example of a for loop
        // for (int i = 0; i < 5; i++) {
        //     System.out.println("For loop iteration: " + i);
        // }

        // // Example of a while loop
        // int j = 0;
        // while (j < 5) {
        //     System.out.println("While loop iteration: " + j);
        //     j++;
        // }

        // // Example of a do-while loop
        // int k = 0;
        // do {
        //     System.out.println("Do-while loop iteration: " + k);
        //     k++;
        // } while (k < 5);

        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int i = 1;

        // // Example of a while loop with user input
        // while (i < n) {
        //     System.out.println(i);
        //     i++;
        // }

        // // Example of a while loop that calculates the sum of numbers from 0 to n
        // int sum = 0;
        // while (i <= n) {
        //     sum += i;
        //     i++; 
        // }
        // System.out.println("Sum is: " + sum);

        // // Example of a for loop that prints "Hello World" n times
        // for (i = 0; i < n; i++) {
        //     System.out.println("Hello World " + i);
        // }

        // // Example of a for loop that prints "****" n times
        // for (i = 0; i < n; i++) {
        //     System.out.println("****");
        // }

        // // Example of a whil loop that prints the reverse of a number
        // int rev = 0;         // Variable to store the reversed number
        // while(n!= 0) {
        //     int digit = n % 10;          // Get the last digit
        //     rev = (rev*10) + digit;      // to store the reversed number
        //     n = n / 10;                  // Remove the last digit from n
        // }
        // System.out.println("Reversed number is: " + rev);

        // // Example of a while loop that continues until the last digit is multiple of 10
        // System.out.println("You entered: " + n);
        // while(true){
        //     if (n % 10 == 0) {
        //         System.out.println("you entered multiple of 10: " + n);
        //         break; // Exit the loop if the last digit is 0
        //     } else {
        //         n = sc.nextInt(); // Read a new number
        //         System.out.println("You entered: " + n);
        //     }
        // }

        // // Example to check if a number is prime using a for loop
        // boolean isPrime = true;
        // if (n <= 1) {
        //     isPrime = false;       // 0 and 1 are not prime numbers
        // } else {
        //     for (i = 2; i <= Math.sqrt(n); i++) {
        //         if (n % i == 0) {
        //             isPrime = false;       // Found a divisor, not prime
        //             break;
        //         }
        //     }
        //     if (isPrime) {
        //         System.out.println(n + " is a prime number.");
        //     } else {
        //         System.out.println(n + " is not a prime number.");
        //     }
        // }
        
        sc.close();
    }
}
