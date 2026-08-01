public class arrangingCoins {
    public static int arrange(int n) {
        long left = 0;
        long right = n;
        int ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coinsNeeded = (mid * (mid + 1)) / 2;

            if (coinsNeeded <= n) {
                ans = (int) mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(arrange(5));
    }
}
