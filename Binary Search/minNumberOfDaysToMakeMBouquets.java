public class minNumberOfDaysToMakeMBouquets {
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean canMakeBouquets(int[] bloomDay, int m, int k, int mid) {
        int count = 0;
        for (int bloom : bloomDay) {
            if (bloom <= mid) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                count = 0;
                m--;
            }
        }
        return m <= 0;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }
}
