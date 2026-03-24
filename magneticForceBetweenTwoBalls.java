import java.util.Arrays;

public class magneticForceBetweenTwoBalls {
    public static int maxDist(int[] position, int m) {
        Arrays.sort(position);
        int low = 1; // The minimum distance between any two balls can be 1 (if they are adjacent).
        int high = position[position.length - 1] - position[0];
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(position, m, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean canPlace(int[] position, int m, int dist) {
        int count = 1;
        int last = position[0];
        for (int i = 0; i < position.length; i++) {
            if (position[i] - last >= dist) { // If the distance between the current position and the last position
                                              // where we placed a ball is greater than or equal to dist, we can place
                                              // another ball here.
                count++;
                last = position[i];
            }
            if (count >= m)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int position[] = { 1, 2, 3, 4, 7 };
        int m = 3;
        System.out.println(maxDist(position, m));
    }
}
