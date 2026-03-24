public class powofnrecopt {
    public static int optimizedPow(int a, int n) {
        if (n == 0) {
            return 1;
        }

        int halfPow = optimizedPow(a, n / 2);
        int halfPowsq = halfPow * halfPow;

        if (n % 2 != 0) {
            halfPowsq = halfPowsq * a;
        }
        return halfPowsq;
    }

    public static void main(String[] args) {
        int a = 2;
        int n = 10;
        int result = optimizedPow(a, n);
        System.out.println(a + " raised to the power of " + n + " is: " + result);
    }
}
