public class fibonaccirec {
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int fibn1 = fibonacci(n - 1);
        int fibn2 = fibonacci(n - 2);
        int fibn = fibn1 + fibn2;
        return fibn;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}
