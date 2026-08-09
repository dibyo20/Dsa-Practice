public class smallestDivisibleDigitProductOne {
    public static int smallestNumber(int n, int t) {
        while (true) {
            int num = n;
            int product = 1;
            while (num > 0) {
                int digit = num % 10;
                product *= digit;
                num /= 10;
            }
            if (product % t == 0) {
                return n;
            }
            n++;
        }
    }

    public static void main(String[] args) {
        int n = 1;
        int t = 2;
        System.out.println(smallestNumber(n, t));
    }
}
