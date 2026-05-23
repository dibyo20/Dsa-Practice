public class kokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFinish(piles, mid, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean canFinish(int[] piles, int mid, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + mid - 1) / mid; // This is equivalent to Math.ceil(pile / mid).
            if (hours > h) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
}
