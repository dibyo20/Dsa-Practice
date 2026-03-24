import java.util.*;

public class subarraySumEqualToK {
    public static void main(String args[]) { // Tc: O(n)
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1); // Store the count of occurrences of the sum
        }
        System.out.println("Count of subarrays with sum equal to " + k + ": " + ans);
    }
}   
