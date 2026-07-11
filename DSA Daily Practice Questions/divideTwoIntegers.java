public class divideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int ans = 0;

        while (dvd >= dvs) {
            long temp = dvs;
            int multiple = 1;

            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            ans += multiple;
        }
        return isNegative ? -ans : ans;
    }
    public static void main(String[] args) {
        System.out.println(divide(43, 3));
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(-43, 3));
        System.out.println(divide(-43, -3));
        System.out.println(divide(Integer.MIN_VALUE, -1));
        System.out.println(divide(Integer.MIN_VALUE, 1));
    }
}
