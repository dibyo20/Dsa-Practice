import java.util.*;

public class slidingWindowMedian {
    static TreeMap<Integer, Integer> left = new TreeMap<>();
    static TreeMap<Integer, Integer> right = new TreeMap<>();

    static int leftSize = 0;
    static int rightSize = 0;

    public static double[] slidingMedian(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];

        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }
        ans[0] = median(k);

        for (int i = k; i < n; i++) {
            remove(nums[i - k]);
            add(nums[i]);
            ans[i - k + 1] = median(k);
        }
        return ans;
    }

    private static void add(int num) {
        if (!left.isEmpty() && num <= left.lastKey()) {
            left.put(num, left.getOrDefault(num, 0) + 1);
            leftSize++;
        } else if (!right.isEmpty() && num >= right.firstKey()) {
            right.put(num, right.getOrDefault(num, 0) + 1);
            rightSize++;
        } else {
            left.put(num, left.getOrDefault(num, 0) + 1);
            leftSize++;
        }
        balance();
    }

    private static void remove(int num) {
        if (!left.isEmpty() && num <= left.lastKey()) {
            removeFromMap(left, num);
            leftSize--;
        } else {
            removeFromMap(right, num);
            rightSize--;
        }
        balance();
    }

    private static void balance() {
        while (leftSize > rightSize) {
            int num = left.lastKey();
            removeFromMap(left, num);
            leftSize--;

            right.put(num, right.getOrDefault(num, 0) + 1);
            rightSize++;
        }

        while (rightSize > leftSize + 1) {
            int num = right.firstKey();
            removeFromMap(right, num);
            rightSize--;

            left.put(num, left.getOrDefault(num, 0) + 1);
            leftSize++;
        }
    }

    private static void removeFromMap(TreeMap<Integer, Integer> map, int num) {
        int count = map.get(num);

        if (count == 1) {
            map.remove(num);
        } else {
            map.put(num, count - 1);
        }
    }

    private static double median(int k) {
        if (k % 2 == 1) {
            return right.firstKey();
        }

        long a = left.lastKey();
        long b = right.firstKey();
        return (a + b) / 2.0;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        double[] medians = slidingMedian(nums, k);

        for (double median : medians) {
            System.out.print(median + " ");
        }
    }
}
