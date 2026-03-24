import java.util.*;

public class largestSubarraySum0 {
    public static void main(String args[]) { // Tc: O(n)
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, j - map.get(sum));
            } else {
                map.put(sum, j); // Store the first occurrence of the sum
            }
        }
        System.out.println("Length of the longest subarray with sum 0: " + maxLength);
    }
}
