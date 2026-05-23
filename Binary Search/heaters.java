import java.util.Arrays;

public class heaters {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = 0;
        for (int house : houses) {
            radius = Math.max(radius, getClosestDistance(house, heaters));
        }

        return radius;
    }

    public static int getClosestDistance(int house, int[] heaters) {
        int low = 0;
        int high = heaters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (heaters[mid] == house) {
                return 0;
            } else if (heaters[mid] < house) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int leftDistance = Integer.MAX_VALUE;
        int rightDistance = Integer.MAX_VALUE;

        if (high >= 0) { // Nearest heater on left side
            leftDistance = house - heaters[high];
        }

        if (low < heaters.length) { // Nearest heater on right side
            rightDistance = heaters[low] - house;
        }

        return Math.min(leftDistance, rightDistance);
    }

    public static void main(String[] args) {
        int[] houses = { 1, 2, 3 };
        int[] heaters = { 2 };

        System.out.println("The minimum radius of the heaters is: " + findRadius(houses, heaters));
    }
}
