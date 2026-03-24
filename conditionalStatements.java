import java.util.*;

public class conditionalStatements {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Check if a number is even or odd

        // System.out.print("Enter a number: ");
        // int num = sc.nextInt();
        // if (num % 2 == 0) {
        // System.out.println(num + " is an even number.");
        // } else {
        // System.out.println(num + " is an odd number.");
        // }

        // int num = sc.nextInt();;
        // switch (num) {
        // case 1:
        // System.out.println("You entered 1");
        // break;
        // case 2:
        // System.out.println("You entered 2");
        // break;
        // default:
        // break;
        // }

        System.out.println("Enter the first integer 'a'");
        int a = sc.nextInt();
        System.out.println("Enter the second integer 'b'");
        int b = sc.nextInt();
        System.out.println("Enter an operator (+, -, *, /, %)");
        char operator = sc.next().charAt(0);

        switch (operator) {
            case '+':
                System.out.println("Sum: " + (a + b));
                break;
            case '-':
                System.out.println("Difference: " + (a - b));
                break;
            case '*':
                System.out.println("Product: " + (a * b));
                break;
            case '/':
                if (b != 0) {
                    System.out.println("Quotient: " + (a / b));
                } else {
                    System.out.println("Cannot divide by zero.");
                }
                break;
            case '%':
                if (b != 0) {
                    System.out.println("Remainder: " + (a % b));
                } else {
                    System.out.println("Cannot divide by zero.");
                }
                break;
            default:
                System.out.println("Invalid operator. Please use +, -, *, /, or %.");
                break;
        }

        sc.close();
    }
}
