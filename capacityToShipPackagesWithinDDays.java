// This approach is similar to kokoEatingBananas, we are trying to find the minimum capacity to ship packages within D days using binary search. 
// The low end of the search is the maximum weight (the heaviest package) and the high end is the sum of all weights (if we ship all packages in one day). 
// We then check if we can ship all packages within D days with the current capacity (mid) and adjust our search range accordingly until we find the minimum capacity that can ship within D days.

public class capacityToShipPackagesWithinDDays {
    public static int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for (int w : weights) {
            low = Math.max(low, w); // minimum capacity to ship the heaviest package
            high += w; // maximum capacity to ship all packages in one day
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1; // Try smaller capacity to find the minimum capacity that can ship within D days
            } else {
                low = mid + 1; // Try bigger capacity to ship within D days
            }
        }
        return ans;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {
        int daysUsed = 1;
        int currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysUsed++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }
        return daysUsed <= days;
    }

    public static void main(String[] args) {
        int weights[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}
