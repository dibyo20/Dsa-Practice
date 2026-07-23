public class newtonRaphsonMethodToFindSqrtOfX {
    public static int sqrt(int x) {
        if (x == 0)
            return 0;

        long guess = x;
        while (guess * guess > x) {
            guess = (guess + x / guess) / 2;
        }

        return (int) guess;
    }

    public static void main(String args[]) {
        System.out.println(sqrt(100));
    }
}
