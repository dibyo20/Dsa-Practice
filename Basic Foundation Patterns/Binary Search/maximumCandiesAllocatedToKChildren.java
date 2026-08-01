public class maximumCandiesAllocatedToKChildren {
    public static int maximumCandies(int[] candies, long k) {
        int start = 1;
        int end = 0;
        for (int candy : candies) {
            end = Math.max(end, candy);
        }
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(candies, k, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static boolean check(int[] candies, long k, int mid) {
        long count = 0;
        for (int i = 0; i < candies.length; i++) {
            count += candies[i] / mid;
        }
        return count >= k;
    }

    public static void main(String[] args) {
        int[] candies = { 5, 8, 6 };
        System.out.println(maximumCandies(candies, 3));
    }
}
