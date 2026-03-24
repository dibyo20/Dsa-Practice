import java.util.HashMap;

public class contigousGoodSubarraySum {
    public static boolean isGoodSubarray(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int remainder = prefixSum % k;

            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 23, 2, 4, 6, 7 };
        System.out.println(isGoodSubarray(nums, 6));
    }
}
