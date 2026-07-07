public class concatenateNonZeroDigitsAndMultiplyBySumOne {
    public static long concatenateNonZeroDigits(int n) {
        int divisor = 1;
        while (n / divisor >= 10) {
            divisor *= 10;
        }

        int sum = 0;
        int num = 0;
        while (divisor > 0) {
            int digit = n / divisor;
            if (digit != 0) {
                num = num * 10 + digit;
                sum += digit;
            }
            n = n % divisor;
            divisor /= 10;
        }
        return (long) num * sum;
    }

    public static void main(String[] args) {
        System.out.println(concatenateNonZeroDigits(10203004));
    }
}
