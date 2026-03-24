import java.util.*;

public class functions {
    public static void printHelloWorld() {
        System.out.println("Hello World!");
        return;
    }

    public static int calculateSum(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping: a = " + a + ", b = " + b);
    }   

    public static int product(int a, int b) {
        int product = a * b;
        return product;
    }

    public static int factorial(int n){
        int fact = 1;
        for (int i = 1; i <=n ; i++) {
            fact = fact * i;    
        }
        return fact;
    }

    public static int binCoeff(int n, int r){
        int a = factorial(n);
        int b = factorial(r);
        int c = factorial(n - r);
        int binCoeff = a / (b * c);
        return binCoeff;
    }

    public static  int sum (int a, int b) {
        return a + b;
    }

    public static float sum(float a, float b) {
        return a + b;
    }

    public static boolean isPrime(int n){
        if(n==2) {
            return true;       // 2 is prime
        }

        // // boolean isPrime = true;
        // for(int i = 2; i < n; i++) {
        //     if (n % i == 0) {
        //         return false;       // n is divisible by i, hence not prime
        //     }
        // }

        for(int i =2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;       // n is divisible by i, hence not prime
            }
        }
        return  true;       // n is prime
    }

    public static void isPrimeInRange(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        return;
    }

    public static void binToDec(int n) {
        int dec = 0;
        int base = 1;
        while (n > 0) {
            int lastDigit = n % 10;
            n = n / 10;
            dec += lastDigit * base;
            base *= 2;
        }
        System.out.println("Decimal equivalent: " + dec);
    }

    public static void decToBin(int n) {
        int pow = 0;
        int binNum = 0;
        while (n > 0) {
            int rem = n % 2;
            binNum += rem * (int)Math.pow(10, pow);
            pow++;
            n = n / 2;
        }
        System.out.println("Binary equivalent: " + binNum);
        }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        // int b = sc.nextInt();
        // int sum = calculateSum(a, b);
        // System.out.println("Sum is: " + sum);
        // swap(a, b);
        // int prod = product(a, b);
        // System.out.println("Product is: " + prod);
        // int fact = factorial(a);
        // System.out.println("Factorial of " + a + " is: " + fact);
        // int binCoeff = binCoeff(a, b);
        // System.out.println("Binomial Coefficient C(" + a + ", " + b + ") is: " + binCoeff);
        // System.out.println("Sum of integers: " + sum(3, 4));
        // System.out.println("Sum of floats: " + sum(3.5f, 4.5f));
        // System.out.print(isPrime(a));
        // System.out.print("Prime numbers in range " + a + " to " + b + ": ");
        // isPrimeInRange(a, b);
        // binToDec(a);
        decToBin(a);
        sc.close();
    }
}


    

