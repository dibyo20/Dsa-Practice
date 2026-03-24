public class kokoEatingBananas {
    public static int minKokoSpeed(int piles[], int h) {
        int low = 1;
        int high = 0;
        for (int p : piles) {
            high = Math.max(high, p);
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFinish(piles, h, mid)) {
                ans = mid;
                high = mid - 1; // try smaller k.
            } else {
                low = mid + 1; // try larger k.
            }
        }
        return ans;
    }

    private static boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // Sortcut for Math.ceil(pile / (double) k).
            if (hours > h)
                return false; // This avoids unnecessary loops when already exceeds h, helpful for large
                              // inputs.
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        int piles[] = { 3, 6, 7, 11 };
        int h = 8;
        System.out.println(minKokoSpeed(piles, h));
    }
}
