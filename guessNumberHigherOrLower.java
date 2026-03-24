public class guessNumberHigherOrLower {
    static int pick = 6;

    public static int guess(int num) {
        if (num > pick) {
            return -1; // too high
        } else if (num < pick) {
            return 1;  // too low
        } else {
            return 0;  // correct
        }
    }

    public static int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                end = mid - 1;   // go left
            } else {
                start = mid + 1; // go right
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(guessNumber(n));
    }
}