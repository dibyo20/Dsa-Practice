import java.util.*;

public class longestSubarrayWithSumK {
    public static int longestSubarray(int[] arr, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == K) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum - K)) {
                int len = i - map.get(sum - K);
                maxLen = Math.max(maxLen, len);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = { 1, -1, 5, -2, 3 };
        int K = 3;

        int result = longestSubarray(arr, K);
        System.out.println("Length of the longest subarray: " + result);
    }
}
